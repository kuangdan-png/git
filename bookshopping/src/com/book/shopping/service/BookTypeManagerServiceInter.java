package com.book.shopping.service;

import java.util.List;

import com.book.shopping.entity.BookTypeInfo;

public interface BookTypeManagerServiceInter {
	/**
	 * 1、查询图书类型列表信息
	 * @return
	 */
	List<BookTypeInfo> searchBookTypeList();
}
