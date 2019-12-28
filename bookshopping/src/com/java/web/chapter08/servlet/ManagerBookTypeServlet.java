package com.java.web.chapter08.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.shopping.entity.BookTypeInfo;

public class ManagerBookTypeServlet extends HttpServlet{

	private static final long serialVersionUID = 6763156711737604389L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(" doGet method ");
		
		//1)null（没有指向的具体对象)
		//2)size=0 (空数据)
		List<BookTypeInfo> typeInfos = new ArrayList<BookTypeInfo>();
		
		/*for(int i = 10 ; i <= 20; i++){
			BookTypeInfo obj = new BookTypeInfo("T00" + (i+10), "计算机" + i, "bookManagerServlet", "computer" +i+".jpg", "T0001", i, "....");
			typeInfos.add(obj);
		}
		*/
		req.getSession().setAttribute("BOOK_TYPE_LIST", typeInfos);
		
		//resp.sendRedirect("chapter08/jstlcore.jsp");
		
		resp.sendRedirect("chapter08/codtion.jsp");
	}
	
}
