package com.book.shopping.service;

import java.util.List;

import com.book.shopping.dao.BookTypeManagerDaoImpl;
import com.book.shopping.dao.BookTypeManagerDaoInter;
import com.book.shopping.entity.BookTypeInfo;

public class BookTypeManagerServiceImpl implements BookTypeManagerServiceInter {
	private BookTypeManagerDaoInter bookTypeManagerDaoImpl=new BookTypeManagerDaoImpl();
	
	@Override
	public List<BookTypeInfo> searchBookTypeList() {
		String sql = "select bookTypeNo,bookTypeName,bookTypeParentNo,bookTypeLinkUrl,bookTypeImgUrl,bookTypeOrderNo,bookTypeDescipt from booktypeinfo";
		return bookTypeManagerDaoImpl.searchBookTypeList(sql);
	}
	
	public static void main(String[] args) {
		System.out.println(new BookTypeManagerServiceImpl().searchBookTypeList().size());
	}
}
