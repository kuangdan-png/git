package com.book.shopping.dao;

import java.util.List;

import com.book.shopping.entity.BookInfo;
import com.book.shopping.entity.BookTypeInfo;

/**
 * 图书类型管理数据访问接口类
 * 前缀(Book) + 表名遵循帕斯卡命名 + Dao + Inter
 * @author Administrator
 *
 */
public interface BookTypeManagerDaoInter {
	/**
	 * 1、查询所有图书类型信息
	 * @param sql 传递过来的SQL
	 * @return List<BookTypeInfo> 返回图书类型列表
	 */
	List<BookTypeInfo> searchBookTypeList(String sql);

}
