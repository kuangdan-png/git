<%@page import="com.book.shopping.entity.BookInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <td><div style="text-align:right; margin:5px 10px 5px 0px"><a href="index.html">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;旅游&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表</div>
        <table cellspacing="0" class="listcontent">
        <tr>
          <td><h1>商品目录</h1><hr/><h1>计算机类</h1>&nbsp;&nbsp;&nbsp;&nbsp;共386999种商品<hr/>
          <img src="images/miniicon2.gif" />&nbsp;&nbsp;&nbsp;&nbsp;计算机类的子分类&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;JAVA&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;ASP.NET&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;网站设计&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;图形处理
		  
		  <div style="margin-top:20px; margin-bottom:5px"><img src="images/productlist.gif" width="631" height="38" /></div>
		  
		  <table cellspacing="0" class="booklist">
		  <tr>
		  <%
		  	List<BookInfo> bookInfos =(List<BookInfo>)session.getAttribute("BOOK_INFO_LIST");
		  	for(int i = 0; i < bookInfos.size(); i++){
		  		BookInfo bookInfo = bookInfos.get(i);
		  %>
              <td>
              	<div class="divbookpic">
              		<p>
              			<a href="info.html">
              				<img src="bookcover/<%=bookInfo.getBookImage()%>" width="115" height="129" border="0" />
              			</a>
              		</p>
              	</div>
                <div class="divlisttitle">
                	<a href="info.html">书名 <%=bookInfo.getBookName()%><br />
                		  售价： <%=bookInfo.getBookPrice()%> </a>
                </div>
             </td>
             <!-- 1、当前行如果循环输出了四本书则需要结束当前行(tr),开启下一行(tr) -->
             <%
             	/*Loop1:i=0 if(1 % 4 == 0 false)
             	  Loop2:i=1 if(2 % 4 == 0 false)
           		  Loop3:i=2 if(3 % 4 == 0 false)
                  Loop4:i=3 if(4 % 4 == 0 true)*/
             if( (i+1) % 4 == 0 && i!=bookInfos.size()-1){
             %>	
             	</tr>
             	<tr>
             <%
             	}
             %>
          <%}%>
          	</tr>
         </table>
<div class="pagination"> 
	<ul> 
		<li class="disablepage"><< 第一页 </li> 
		<li class="disablepage"><< 上一页 </li> 
		<li class="nextpage"><a href="#">下一页 >></a></li> 
		<li class="disablepage"><< 最末页 </li> 
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