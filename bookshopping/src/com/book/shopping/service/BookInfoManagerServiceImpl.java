package com.book.shopping.service;

import java.util.List;

import com.book.shopping.dao.BookInfoManagerDaoImpl;
import com.book.shopping.dao.BookInfoManagerDaoInter;
import com.book.shopping.entity.BookInfo;

public class BookInfoManagerServiceImpl implements BookInfoManagerServiceInter {
	private BookInfoManagerDaoInter bookInfoManagerDaoImpl = new BookInfoManagerDaoImpl();
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.service.BookInfoManagerServiceInter#searchBookListInfoByBookTypeNo(java.lang.String)
	 */
	@Override
	public List<BookInfo> searchBookListInfoByBookTypeNo(String bookTypeNo, int currentPageNumber, int pageSize) {
		String sql = "select * from bookinfo where bookTypeNo = ? limit ? , ? ";
		Object[] arrays = {bookTypeNo,((currentPageNumber-1)*pageSize),pageSize};
		return bookInfoManagerDaoImpl.searchBookListInfoByBookTypeNo(sql,arrays);
	}
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.service.BookInfoManagerServiceInter#calcTotalPages(java.lang.String, int)
	 */
	@Override
	public int calcTotalPages(String bookTypeNo, int pageSize) {
		String sql = "select count(booktypeno) counumber from bookinfo where booktypeno = ? ";
		Object[] arrays = {bookTypeNo,pageSize};
		return bookInfoManagerDaoImpl.calcTotalPages(sql,arrays);
	}
	/*
	 * (non-Javadoc)
	 * @see com.book.shopping.service.BookInfoManagerServiceInter#searchBookDescriptionByBookInNo(java.lang.String)
	 */
	@Override
	public BookInfo searchBookDescriptionByBookInNo(String bookInfoNo) {
		String sql = "select * from bookinfo where bookNo = ?";
		Object[] arrays = {bookInfoNo};
		return bookInfoManagerDaoImpl.searchBookInfoDesc(sql, arrays);
	}
}
