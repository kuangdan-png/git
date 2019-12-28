package com.book.shopping.service;

import java.util.List;

import com.book.shopping.entity.BookInfo;

public interface BookInfoManagerServiceInter {
	/**
	 * 1、根据传递的图书类型编号查询返回图书列表信息
	 * @param bookTypeNo
	 * @param pageSize 
	 * @param currentPageNumber 
	 * @return
	 */
	List<BookInfo> searchBookListInfoByBookTypeNo(String bookTypeNo, int currentPageNumber, int pageSize);
	
	/**
	 * 2、根据图书类型编号与每页显示条数计算出总页数
	 * @param bookTypeNo
	 * @param pageSize
	 * @return
	 */
	int calcTotalPages(String bookTypeNo , int pageSize);
	/**
	 * 3、根据图书信息编号查询返回图书详情
	 * @param bookInfoNo
	 * @return
	 */
	BookInfo searchBookDescriptionByBookInNo(String bookInfoNo);
	
}
