<%@page import="com.book.shopping.entity.BookInfo"%>
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
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>
<body class="main">
	<jsp:include page="booktop.jsp"/>
	<div id="divpagecontent">
 	 <table width="100%" border="0" cellspacing="0">
   		 <tr>
      		<td width="25%">
      			<jsp:include page="booktypeaslide.jsp"/>
      		</td>
      	 <td>
      	<div style="text-align:right; margin:5px 10px 5px 0px">
      		<a href="index.html">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;旅游&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
      	</div>
        <table cellspacing="0" class="listcontent">
        	<tr>
          		<td>
          			<h1>商品目录</h1>
          				<hr/>
          			<h1>计算机类</h1>
          				&nbsp;&nbsp;&nbsp;&nbsp;共386999种商品
          			<hr/>
         			 	<img src="images/miniicon2.gif" />&nbsp;&nbsp;&nbsp;&nbsp;计算机类的子分类&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;JAVA&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;ASP.NET&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;网站设计&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;图形处理
		  
		  				<div style="margin-top:20px; margin-bottom:5px">
		  					<img src="images/productlist.gif" width="631" height="38" />
		  				</div>
		  
		  <table cellspacing="0" class="booklist">
		  <tr>
		  	<c:if test="${(sessionScope.BOOK_INFO_LIST ne null) and (sessionScope.BOOK_INFO_LIST.size() > 0) }">
              	<c:forEach items="${sessionScope.BOOK_INFO_LIST}" var="bookInfo" varStatus="indexObj">
              		<td>
		              	<div class="divbookpic">
		              		<p>
		              			<a href="bookInfoManagerServlet?bookInfoNo=${bookInfo.bookNo}&flag=showBookDesc">
		              				<img src="bookcover/${bookInfo.bookImage}" width="115" height="129" border="0" />
		              			</a>
		              		</p>
		              	</div>
		                <div class="divlisttitle">
		                	<a href="bookInfoManagerServlet?bookInfoNo=${bookInfo.bookNo}&flag=showBookDesc">书名${bookInfo.bookName} <br />
		                		  售价：${bookInfo.bookPrice} </a>
		                </div>
	             	</td>
	             	<c:if test="${(((indexObj.index+1) mod 4 ) eq 0) and ((indexObj.index) != (sessionScope.BOOK_INFO_LIST.size() -1)) }">
	             		</tr>
	             		<tr>
	             	</c:if>
              	</c:forEach>
             </c:if>
          	</tr>
         </table>
		<div class="pagination"> 
			共[${sessionScope.TOTAL_PAGES}]页,当前第[${sessionScope.CURRENT_PAGE}]页
			<ul> 
				<li class="disablepage">
					<a href="bookInfoManagerServlet?booktypeno=${sessionScope.BOOK_TYPE_NO}&currentPage=1&flag=pagegation"><< 第一页</a>
			    </li> 
			    <c:if test="${sessionScope.CURRENT_PAGE gt 1 }">
					<li class="disablepage">
						<a href="bookInfoManagerServlet?booktypeno=${sessionScope.BOOK_TYPE_NO}&currentPage=${sessionScope.CURRENT_PAGE - 1 }&flag=pagegation"><<上一页</a>
					</li> 
				</c:if>
				
				 <c:if test="${sessionScope.CURRENT_PAGE lt sessionScope.TOTAL_PAGES }">
					<li class="disablepage">
						<a href="bookInfoManagerServlet?booktypeno=${sessionScope.BOOK_TYPE_NO}&currentPage=${sessionScope.CURRENT_PAGE + 1 }&flag=pagegation">下一页>></a>
					</li> 
				</c:if>
				<li class="disablepage">
					<a href="bookInfoManagerServlet?booktypeno=${sessionScope.BOOK_TYPE_NO}&currentPage=${sessionScope.TOTAL_PAGES}&flag=pagegation"><< 最末页</a>
			    </li> 
			</ul> 
		</div> 
		  </td>
        </tr>
      </table></td>
    </tr>
  </table>
</div>
	<jsp:include page="bookbottom.jsp"/>
</body>
</html>