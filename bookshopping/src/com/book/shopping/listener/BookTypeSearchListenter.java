package com.book.shopping.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.book.shopping.entity.BookTypeInfo;
import com.book.shopping.service.BookTypeManagerServiceImpl;
import com.book.shopping.service.BookTypeManagerServiceInter;
/**
 * 当容器启动时则查询数据表中的图书类型信息存入application范围
 * @author Administrator
 * ServletContext application =new xx();
 * ServletContextListener(servlet:servletContext,jsp:application)
 */
public class BookTypeSearchListenter implements ServletContextListener {
	
	private BookTypeManagerServiceInter bookTypeManagerServiceImpl=new BookTypeManagerServiceImpl();
	
	public BookTypeSearchListenter(){
	}
	/*
	 * Event :事件(JOption.showMessageDialog())
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		//1、当容器启动时，当前针对servletcontent监听器会自动进行监听，调用图书类型管理中的查询所有图书分类的方法
		List<BookTypeInfo> bookTypeList= bookTypeManagerServiceImpl.searchBookTypeList();
		//2、返回所有图书类型的信息，存入application范围
		ServletContext application= event.getServletContext();
		application.setAttribute("BOOKTYPE_LIST", bookTypeList);//String key,object value
		//3、让其他页面进行调用显示
	}

}
