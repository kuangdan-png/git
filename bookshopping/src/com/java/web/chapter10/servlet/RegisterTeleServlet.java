package com.java.web.chapter10.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterTeleServlet extends HttpServlet {

	private static final long serialVersionUID = -3625660509860466031L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//一、传统方式
		/*
		System.out.println(" invoke doGet method");
		String telenumber=req.getParameter("telenumber");
		System.out.println("telenumber="+telenumber);
		if("15869720053".equals(telenumber)){
			req.getSession().setAttribute("MESSAGE", "对不起，当前手机号("+telenumber+")已被注册，请更换");
		}else{
			req.getSession().setAttribute("MESSAGE", "恭喜您，当前手机号("+telenumber+")可以进行注册");
		}
		resp.sendRedirect("chapter10/registertele.jsp");
		*/
		
		//二、ajax方式
		String teleNumber=req.getParameter("teleNumber");
		String message="";
		if("15869720053".equals(teleNumber)){
			message="对不起，当前手机号("+teleNumber+")已被注册，请更换！";
		}else{
			message="恭喜您，当前手机号("+teleNumber+")可以进行注册";
		}
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		out.write(message);
		out.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" call doPost method");
		String teleNumber=req.getParameter("teleNumber");
		String message="";
		if("15869720053".equals(teleNumber)){
			message="对不起，当前手机号("+teleNumber+")已被注册，请更换！";
		}else{
			message="恭喜您，当前手机号("+teleNumber+")可以进行注册";
		}
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
			out.write(message);
		out.close();
	}
}
