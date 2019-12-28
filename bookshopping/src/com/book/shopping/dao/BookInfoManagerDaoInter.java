package com.book.shopping.dao;

import java.util.List;

import com.book.shopping.entity.BookInfo;

public interface BookInfoManagerDaoInter {
	/**
	 * 根据传递的SQL语句及图书类型编号查询返回图书信息列表
	 * @param sql
	 * @param arrays
	 * @return
	 */
	List<BookInfo> searchBookListInfoByBookTypeNo(String sql, Object[] arrays);
	
	/**
	 * 2、根据图书类型计算总页数
	 * @param sql
	 * @param arrays
	 * @return
	 */
	int calcTotalPages(String sql, Object[] arrays);
	
	/**
	 * 3、查询图书详情
	 * @param sql
	 * @param arrays
	 * @return
	 */
	BookInfo searchBookInfoDesc(String sql, Object[] arrays);
}
