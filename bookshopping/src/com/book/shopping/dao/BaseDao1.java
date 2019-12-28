package com.book.shopping.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 数据库工具类
 * @author kd
 * @Date 2019年7月4日 下午2:15:22
 * @Version 1.0
 */
public class BaseDao1 {
	private static String DRIVER_CLASS=null;
	private static String URL=null;
	private static String DB_USER_NAME=null;
	private static String DB_USER_PASS=null;
	
	static{
		Properties properties=new Properties();
		InputStream is= BaseDao1.class.getClassLoader().getResourceAsStream("bookshopping.properties");
		try {
			properties.load(is);
			DRIVER_CLASS=properties.getProperty("bookshopping.driverclass");
			URL=properties.getProperty("bookshopping.url");
			DB_USER_NAME=properties.getProperty("bookshopping.dbusername");
			DB_USER_PASS=properties.getProperty("bookshopping.dbuserpass");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取并返回连接对象
	 * @return Connection 返回连接对象
	 * @throws ClassNotFoundException 类未找到异常
	 * @throws SQLException SQL异常
	 */
	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER_CLASS);
		Connection connection=DriverManager.getConnection(URL, DB_USER_NAME, DB_USER_PASS);
		return connection;
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
		System.out.println(new BaseDao1().createConnection());
	}
}
