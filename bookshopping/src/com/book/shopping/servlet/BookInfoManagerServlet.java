package com.book.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.shopping.entity.BookInfo;
import com.book.shopping.service.BookInfoManagerServiceImpl;
import com.book.shopping.service.BookInfoManagerServiceInter;

public class BookInfoManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 235382095435364701L;
	
	private BookInfoManagerServiceInter bookInfoManagerServiceImpl = new BookInfoManagerServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取标识的区分参数
		String flag = req.getParameter("flag");
		
		//2、根据区分参数的不同值从而调用不同的处理方法
		if("pagegation".equals(flag.trim())){
			this.doPagegationByBookTypeNo(req, resp);
		}else if("showBookDesc".equals(flag.trim())){
			this.doShowBookDescByBookInfoNo(req, resp);
		}
				
	}
	/**
	 * 2、根据点击的图书查询显示图书详情
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doShowBookDescByBookInfoNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取到点击的图书信息的主键编号
		String bookInfoNo = req.getParameter("bookInfoNo");
		
		//2、调用业务逻辑类的根据图书编号查询图书详情的方法(ctrl + 1)
		BookInfo bookInfoObj = bookInfoManagerServiceImpl.searchBookDescriptionByBookInNo(bookInfoNo);
		
		//3、将图书详情对象存储至session范围
		req.getSession().setAttribute("BOOK_INFO_OBJ", bookInfoObj);
		
		//4、跳转至info.jsp页面显示即可
		resp.sendRedirect("info.jsp");
	}
	
	/**
	 * 1、根据图书类型编号及当前页与每条的显示条数进行分页显示功能
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPagegationByBookTypeNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" invoke doPagegationByBookTypeNo ");
		
		//1、从请求的图书类型的超链接中获取图书类型编号
		String bookTypeNo = req.getParameter("booktypeno");
		//System.out.println("bookTypeNO= " + bookTypeNo);
		
		//1_1)获取当前第几页的参数[modify by 2019-07-25 PM:3:08]
		String currentPage = req.getParameter("currentPage");
		
		//1_2)类型转换
		int currentPageNumber = Integer.parseInt(currentPage);
		
		//1_3)声明一个变量用于表示每页显示的条数[固定8]
		int pageSize = 8;
		
		//1_4)将前面获取的超链接传递过来的图书类型编号存储在某个范围[session]
		req.getSession().setAttribute("BOOK_TYPE_NO", bookTypeNo);
		
		//1_5)将当前页码存入 session范围，已页面显示获取
		//1)int --> Integer --> Object
		//2)session.setAttribute(String key , Object object);
		req.getSession().setAttribute("CURRENT_PAGE", currentPageNumber);
		
		//1_6)调用业务逻辑类的计算总页数的方法返回总页数，将总页数存储至session中，传递至页面显示
		int calcTotalPages = bookInfoManagerServiceImpl.calcTotalPages(bookTypeNo, pageSize);
		req.getSession().setAttribute("TOTAL_PAGES", calcTotalPages);
		
		//2、调用业务逻辑层的查询返回图书信息集合方法
		List<BookInfo> bookInfos = bookInfoManagerServiceImpl.searchBookListInfoByBookTypeNo(bookTypeNo,currentPageNumber,pageSize);
		System.out.println("bookInfoList size = " + bookInfos.size());
		//3、将查询的结果存入某个范围
		req.getSession().setAttribute("BOOK_INFO_LIST", bookInfos);
		
		//4、进行页面跳转
		resp.sendRedirect("product_list.jsp");
	}
}
