<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
      							<a href="index.html">首页</a>
      							&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
      							<a href="product_list.html">&nbsp;旅游</a>
      							&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;大勇和小花的欧洲日记
      						</div>
        			<table cellspacing="0" class="infocontent">
       					 <tr>
          					<td>
          						<img src="ad/page_ad.jpg" width="645" height="84" />
		  
		    			<table width="100%%" border="0" cellspacing="0">
              				<tr>
                				<td width="30%">
				
									<div class="divbookcover">
										<p>
											<img src="bookcover/${sessionScope.BOOK_INFO_OBJ.bookImage}" />
										</p>
									</div>
				
									<div style="text-align:center; margin-top:25px">
										<a href="shoppingcarServlet?bookInfoNo=${sessionScope.BOOK_INFO_OBJ.bookNo}">
											<img src="images/buybutton.gif" border="0" />
										</a>
									</div>
								</td>
               					 <td style="padding:20px 5px 5px 5px">
                					<img src="images/miniicon3.gif" width="16" height="13" />
                					<font class="bookname">&nbsp;&nbsp;${sessionScope.BOOK_INFO_OBJ.bookImage}</font>
                					<hr/>作者：${sessionScope.BOOK_INFO_OBJ.bookAuthor} 著<hr/>
				                		  售价：<font color="#FF0000">￥${sessionScope.BOOK_INFO_OBJ.bookPrice}</font>
				                		  &nbsp;&nbsp;&nbsp;&nbsp;
				                		 原价：<s>￥${sessionScope.BOOK_INFO_OBJ.bookPrice}</s><hr/>
				                		出版社：${sessionScope.BOOK_INFO_OBJ.bookPublisher}
									<hr/>
									<p><b>内容简介：</b></p>　　
									${sessionScope.BOOK_INFO_OBJ.bookContent}
								</td>
             				 </tr>
            	</table>		  	
            </td>
        </tr>
      </table>
      </td>
    </tr>
  	</table>
</div>
	<jsp:include page="bookbottom.jsp"/>
</body>
</html>