package com.book.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.book.shopping.entity.BookInfo;
import com.book.shopping.service.BookInfoManagerServiceInter;

public class BookInfoManagerDaoImpl implements BookInfoManagerDaoInter {
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.dao.BookInfoManagerDaoInter#searchBookListInfoByBookTypeNo(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<BookInfo> searchBookListInfoByBookTypeNo(String sql, Object[] arrays) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<BookInfo> bookInfos = new ArrayList<>();
		
		try {
			conn = BaseDao.createConnection();
			statement = conn.prepareStatement(sql);
			for(int i = 0 ; i < arrays.length; i++){
				statement.setObject((i+1), arrays[i]);
			}
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				String bookNo = resultSet.getString("bookNo");
				String bookName = resultSet.getString("bookName");
				String bookPublisher = resultSet.getString("bookPublisher");
				double bookPrice = resultSet.getDouble("bookPrice");
				String bookImage = resultSet.getString("bookImage");
				Date bookPubDate = resultSet.getDate("bookPubDate");
				String bookAuthor = resultSet.getString("bookAuthor");
				String bookContent = resultSet.getString("bookContent");
				String bookDesciption = resultSet.getString("bookDesciption");
				String bookTypeNo = resultSet.getString("bookTypeNo");
				
				BookInfo bookInfo = new BookInfo(bookNo, bookName, bookPublisher, bookPrice, bookImage, bookPubDate, bookAuthor, bookContent, bookDesciption, bookTypeNo);
				
				bookInfos.add(bookInfo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.freeSource(conn, statement, resultSet);
		}
		return bookInfos;
	}
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.dao.BookInfoManagerDaoInter#calcTotalPages(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int calcTotalPages(String sql, Object[] arrays) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int totalPages = 0;
		
		try {
			conn = BaseDao.createConnection();
			statement = conn.prepareStatement(sql);
			statement.setObject(1, arrays[0]);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				int totalCountNumber = resultSet.getInt("counumber");
				//根据总条件以及Object[]中带过来的第二个参数值进行计算
				int pageSize = ((Integer)arrays[1]).intValue();
				totalPages = (totalCountNumber % pageSize == 0) ? (totalCountNumber / pageSize) : (totalCountNumber / pageSize + 1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.freeSource(conn, statement, resultSet);
		}
		return totalPages;
	}
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.dao.BookInfoManagerDaoInter#searchBookInfoDesc(java.lang.String, java.lang.Object[])
	 */
	@Override
	public BookInfo searchBookInfoDesc(String sql, Object[] arrays) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		BookInfo bookInfo = null;
		try {
			conn = BaseDao.createConnection();
			statement = conn.prepareStatement(sql);
			for(int i = 0 ; i < arrays.length; i++){
				statement.setObject((i+1), arrays[i]);
			}
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				String bookNo = resultSet.getString("bookNo");
				String bookName = resultSet.getString("bookName");
				String bookPublisher = resultSet.getString("bookPublisher");
				double bookPrice = resultSet.getDouble("bookPrice");
				String bookImage = resultSet.getString("bookImage");
				Date bookPubDate = resultSet.getDate("bookPubDate");
				String bookAuthor = resultSet.getString("bookAuthor");
				String bookContent = resultSet.getString("bookContent");
				String bookDesciption = resultSet.getString("bookDesciption");
				String bookTypeNo = resultSet.getString("bookTypeNo");
				
				bookInfo = new BookInfo(bookNo, bookName, bookPublisher, bookPrice, bookImage, bookPubDate, bookAuthor, bookContent, bookDesciption, bookTypeNo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.freeSource(conn, statement, resultSet);
		}
		return bookInfo;
	}
}
