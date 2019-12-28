package com.book.shopping.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.shopping.entity.BookInfo;
import com.book.shopping.service.BookInfoManagerServiceImpl;

public class ShoppingcarServlet extends HttpServlet {

private static final long serialVersionUID = 7201270845502418928L;
	
	private BookInfoManagerServiceImpl bookInfoManagerServiceImpl = new BookInfoManagerServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取超链接携带的图书信息的编号
		String bookInfoNo = req.getParameter("bookInfoNo");
		System.out.println("bookInfoNo=" + bookInfoNo);
		
		//2、调用原有的业务逻辑类中根据图书编号查询图书信息对象的方法
		BookInfo bookInfoObj = bookInfoManagerServiceImpl.searchBookDescriptionByBookInNo(bookInfoNo);
		
		//3、将当前点击购买的图书对象放在购物车中
		//3_1)第一次进行先从session中取Map判断是否为空
		HttpSession session = req.getSession();
		System.out.println("session id = " + session.getId());
		Map<String, BookInfo> shoppMap = (Map<String,BookInfo>)session.getAttribute("SHOPPING_CAR");
		
		if(null != shoppMap && !shoppMap.isEmpty()){
			//1、最简洁方式
			/*Set<Entry<String, BookInfo>> entrySet = shoppMap.entrySet();
			for (Entry<String, BookInfo> entry : entrySet) {
				System.out.println(entry.getKey() +"\t" + entry.getValue());
			}*/
			//2、普通方式
			/*Set<String> keySet = shoppMap.keySet();
			for (String string : keySet) {
				System.out.print("key=" + string + " --> value=" + shoppMap.get(string));
			}*/
		}
		
		//如果满足if则不是表示第一次，而是后续次数
		if(null != shoppMap && !shoppMap.isEmpty()){
			//xxx.containsKey()=true 表示原来有这本书
			if(shoppMap.containsKey(bookInfoObj.getBookNo())){
				//表示原来存在有key,则根据key快速找到原来那本书的对象
				bookInfoObj = shoppMap.get(bookInfoObj.getBookNo());
				//对当前这本书将原来的购买数量获取到在此基础上加1操作
				bookInfoObj.setBookNumber((bookInfoObj.getBookNumber() + 1));
			}else{//xxx.containsKey() = false 表示原来这本书未存在
				bookInfoObj.setBookNumber(1);
				shoppMap.put(bookInfoObj.getBookNo(),bookInfoObj);
			}
		}else{//表示第一次
			shoppMap = new HashMap<String,BookInfo>();
			bookInfoObj.setBookNumber(1);
			//B0001 , new BookInfo(xxx,xxx,xxx,xxx,xxx,xxx,xxx);
			shoppMap.put(bookInfoObj.getBookNo(),bookInfoObj);
		}
		
		//4、将Map集合存入session范围
		session.setAttribute("SHOPPING_CAR", shoppMap);
		
		//5、重定向至cart.jsp页面
		resp.sendRedirect("cart.jsp");
	}
}
