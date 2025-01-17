package com.book.shopping.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;


/**
 * 数据库工具类
 * @author kd
 * @Date 2019年7月4日 下午2:15:22
 * @Version 1.0
 */
public class BaseDao {
	private static String DRIVER_CLASS=null;
	private static String URL=null;
	private static String DB_USER_NAME=null;
	private static String DB_USER_PASS=null;
	
	private static String MAXACTIVE=null;
	private static String MAXIDLE=null;
	private static String MINIDLE=null;
	private static String MAXWAIT=null;
	
	static{
		Properties properties=new Properties();
		InputStream is= BaseDao.class.getClassLoader().getResourceAsStream("bookshopping.properties");
		try {
			properties.load(is);
			DRIVER_CLASS=properties.getProperty("bookshopping.driverclass");
			URL=properties.getProperty("bookshopping.url");
			DB_USER_NAME=properties.getProperty("bookshopping.dbusername");
			DB_USER_PASS=properties.getProperty("bookshopping.dbuserpass");
			
			MAXACTIVE=properties.getProperty("bookshopping.maxActive");
			MAXIDLE=properties.getProperty("bookshopping.maxIdle");
			MINIDLE=properties.getProperty("bookshopping.minIdle");
			MAXWAIT=properties.getProperty("bookshopping.maxWait");
		} catch (IOException e) {
			e.printStackTrace();
		}
		initDruidDataSource();
	}
	
	/**
	 * 初始化数据库连接池
	 */
	static DruidDataSource dataSourcePool=null;
	public static void initDruidDataSource(){
		dataSourcePool=new DruidDataSource();
		dataSourcePool.setDriverClassName(DRIVER_CLASS);
		dataSourcePool.setUrl(URL);
		dataSourcePool.setUsername(DB_USER_NAME);
		dataSourcePool.setPassword(DB_USER_PASS);
		dataSourcePool.setMaxIdle(Integer.parseInt(MAXACTIVE));
		dataSourcePool.setMaxIdle(Integer.parseInt(MAXIDLE));
	}
	
	/**
	 * 获取并返回连接对象
	 * @return Connection 返回连接对象
	 * @throws ClassNotFoundException 类未找到异常
	 * @throws SQLException SQL异常
	 */
	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		System.out.println("hello");
		if(null==dataSourcePool || dataSourcePool.isClosed()){
			initDruidDataSource();
		}
		return dataSourcePool.getConnection();
	}
	/**
	 * 释放资源
	 * @param conn 连接对象
	 * @param statement 命令语句对象
	 * @param resultSet 结果集对象
	 */
	public static void freeSource(Connection conn,Statement statement,ResultSet resultSet){
		try {
			if(null!=resultSet){
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(null!=statement){
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(null!=conn){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放资源
	 * @param conn 连接对象
	 * @param statement 命令语句对象
	 */
	public static void freeSource(Connection conn,Statement statement){
		
		try {
			if(null!=statement){
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(null!=conn){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(new BaseDao().createConnection());
	}
}
