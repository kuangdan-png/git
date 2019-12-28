<%@page import="com.book.shopping.entity.BookTypeInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="all" name="robots"/>
<meta name="author" content="Fisher" />
<meta name="Copyright" content="Copyright 2007-2008, 版权所有 www.reefdesign.cn" />
<meta name="description" content="reefdesign" />
<meta name="keywords" content="reefdesign" />
<title>电子书城</title>
</head>
<body>
	<div id="divhead">
		  <table cellspacing="0" class="headtable">
		    <tr>
		      <td><a href="index.html"><img src="images/logo.gif" width="95" height="30" border="0" /></a></td>
		      <td style="text-align:right"><img src="images/cart.gif" width="26" height="23" style="margin-bottom:-4px"/>&nbsp;<a href="cart.jsp">购物车</a>　|　<a href="#">帮助中心</a>　|　<a href="login.html">我的帐户</a>　|　<a href="register.html">新用户注册</a></td>
		    </tr>
		  </table>
	</div>

	<div id="divmenu">
		<!--1、从application范围中获取出所有图书列表的集合
		2、通过循环在booktop.jsp页面中输出所有图书类型名称-->
		<!-- 
			1)application.setAttribute(key,List); 才存在size()
			2)application.setAttrrbute(key,Map); 不能应用size()
		 -->
		<c:if test="${(applicationScope.BOOKTYPE_LIST ne null) and (applicationScope.BOOKTYPE_LIST.size() gt 0) }">
			<c:forEach items="${applicationScope.BOOKTYPE_LIST}" var="bookTypeInfo">
				<a href="bookInfoManagerServlet?booktypeno=${bookTypeInfo.bookTypeNo}&currentPage=1&flag=pagegation">${bookTypeInfo.bookTypeName}</a>　
			</c:forEach>
		</c:if>
		　
		<a href="product_list.html" style="color:#FFFF00">全部商品目录</a>
	</div>

	<div id="divsearch">
		<table width="100%" border="0" cellspacing="0">
	  		<tr>
	    		<td style="text-align:right; padding-right:220px">Search
	  				<input type="text" name="textfield" class="inputtable"/>
					<!--<input name="searchbutton" type="image" src="images/serchbutton.gif" style=" margin-bottom:-4px"/>-->
					<a href="search.html">
						<img src="images/serchbutton.gif" border="0" style="margin-bottom:-4px"/>
					</a>
				</td>
	  		</tr>
		</table>
	</div>
</body>
</html>