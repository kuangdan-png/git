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
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>
<body class="main">
	<table width="100%" border="0" cellspacing="0" style="margin-top:30px">
        <tr>
          <td class="listtitle">分类</td>
        </tr>
         <c:if test="${(applicationScope.BOOKTYPE_LIST ne null) and (applicationScope.BOOKTYPE_LIST.size() gt 0) }">
			<c:forEach items="${applicationScope.BOOKTYPE_LIST}" var="bookTypeInfo">
				<tr>
		          <td class="listtd">
		          		<img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
		            	<a href="bookInfoManagerServlet?booktypeno=${bookTypeInfo.bookTypeNo}&currentPage=1&flag=pagegation">${bookTypeInfo.bookTypeName}</a>
		          </td>
		        </tr>
	    	</c:forEach>
		</c:if>
      </table>
</body>
</html>