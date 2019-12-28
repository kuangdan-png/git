package com.book.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.book.shopping.entity.BookTypeInfo;


public class BookTypeManagerDaoImpl implements BookTypeManagerDaoInter{
	@Override
	public List<BookTypeInfo> searchBookTypeList(String sql) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<BookTypeInfo> bookTypeList = new ArrayList<>();
		
		try {
			connection = BaseDao.createConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){//while(true) , while(false)
				String bookTypeNo= resultSet.getString("bookTypeNo");
				String bookTypeName= resultSet.getString("bookTypeName");
				String bookTypeLinkUrl= resultSet.getString("bookTypeLinkUrl");
				String bookTypeImgUrl= resultSet.getString("bookTypeImgUrl");
				String bookTypeParentNo= resultSet.getString("bookTypeParentNo");
				int bookTypeOrderNo= resultSet.getInt("bookTypeOrderNo");
				String bookTypeDescipt= resultSet.getString("bookTypeDescipt");
				
				BookTypeInfo bookTypeInfo = new BookTypeInfo(bookTypeNo, bookTypeName, bookTypeLinkUrl, bookTypeImgUrl, bookTypeParentNo, bookTypeOrderNo, bookTypeDescipt);
				
				bookTypeList.add(bookTypeInfo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.freeSource(connection, statement, resultSet);
		}
		return bookTypeList;
	}
	public static void main(String[] args) {
		String sql = "select bookTypeNo,bookTypeName,bookTypeParentNo,bookTypeLinkUrl,bookTypeImgUrl,bookTypeOrderNo,bookTypeDescipt from booktypeinfo";
		System.out.println(new BookTypeManagerDaoImpl().searchBookTypeList(sql).size());
	}
}
