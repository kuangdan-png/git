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
		      	<table width="100%" border="0" cellspacing="0" style="margin-top:30px">
		     		<tr>
		          		<td class="listtitle">配送方式、时间及费用</td>
		      		</tr>
		        	<tr>
		          		<td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="news.html">普通快递送货上门</a></td>
		        	</tr>
				
					<tr>	
		         		 <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
		           		 	<a href="news.html">特快专递送货上门(EMS)</a>
		          		</td>
       				</tr>
					<tr>
          				<td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            				<a href="news.html">申通快递送货上门</a>
            			</td>
       			    </tr>
					<tr>
          				<td class="listtd">
          					<img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="news.html">普通邮寄</a>
						</td>
        			</tr>
      			</table>
      		 </td>
     		 <td>
      			<div style="text-align:right; margin:5px 10px 5px 0px"><a href="index.html">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;购物车</div>
   
        		<table cellspacing="0" class="infocontent">
        			<tr>
          				<td>
          					<img src="ad/page_ad.jpg" width="666" height="89" />
           
            			<table width="100%" border="0" cellspacing="0">
             				 <tr>
               					 <td><img src="images/buy1.gif" width="635" height="38" /></td>
             				 </tr>
             				 <tr>
                			 <td>
                
			                <table cellspacing="1" class="carttable">
			                  <tr>
			                    <td width="10%">序号</td>
			                    <td width="40%">商品名称</td>
			                    <td width="10%">市场价</td>
			                    <td width="10%">优惠价</td>
			                    <td width="10%">数量</td>
			                    <td width="10%">小计</td>
			                    <td width="10%">取消</td>
			                  </tr>
			                </table>
                
                  <table width="100%" border="0" cellspacing="0">
                  	<!-- c:set,c:out,c:remove -->
                  	<!--
                  		req.getSession.setAttribute("totalMoney",0.0);
                  	-->
                  	<c:set scope="session" value="0.0"  var="totalMoney"/>
                  	<c:choose>
                  		<c:when test="${sessionScope.SHOPPING_CAR ne null}">
                  			<!-- 
                  				1)以上每循环一次从Map中获取的并不是值对象，而是key-value键/值对(entry)
                  				2)key: entry.getKey()
                  				3)value:entry.getValue() -- BookInfoObj 
                  				4)bookInfoObj.getBookNo() ${bookInfObj.bookNo}
                  					(entry.value.bookNo)
                  			 -->
                  			<c:forEach items="${sessionScope.SHOPPING_CAR}" var="mapEntryObj">
		                  		<tr>
			                      <td width="10%">${mapEntryObj.value.bookNo}</td>
			                      <td width="40%">${mapEntryObj.value.bookName}</td>
			                      <td width="10%">${mapEntryObj.value.bookPrice}</td>
			                      <td width="10%">${mapEntryObj.value.bookPrice}</td>
			                      <td width="10%">
			                      	<input name="text" type="text" value="${mapEntryObj.value.bookNumber}" style="width:20px"/>
			                      </td>
			                      <td width="10%">
			                      	${mapEntryObj.value.bookPrice * mapEntryObj.value.bookNumber}
			                      	<c:set scope="session" value="${sessionScope.totalMoney + (mapEntryObj.value.bookPrice * mapEntryObj.value.bookNumber) }"  var="totalMoney"/>
			                     
			                     	<!-- req.getSession.setAttribute("totalMoney",session.getAttribute("totalMoney") + price * number); -->
			                      </td>
			                      
			                      <td width="10%"><a href="#" style="color:#FF0000; font-weight:bold">X</a></td>
			                    </tr>
		                    </c:forEach>
                  		</c:when>
                  		<c:otherwise>
                  			<tr>
		                      <td width="100%" colspan="7">
		                      	对不起，当前购物车中无商品......
		                      </td>
		                    </tr>
                  		</c:otherwise>
                  	</c:choose>
                    
                    
                  </table>
						   <table cellspacing="1" class="carttable">
		                     <tr>
		                       <td style="text-align:right; padding-right:40px;">
		                       <!-- req.getSession.getAttribute("totalMoney"); -->
		                       	<font style="color:#FF6600; font-weight:bold">合计：&nbsp;&nbsp;<c:out value="${sessionScope.totalMoney}"></c:out>元</font>
		                       </td>
		                      </tr>
		                   </table>
				  		 <div style="text-align:right; margin-top:10px"><a href="product_list.html"><img src="images/gwc_jx.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="order.html"><img src="images/gwc_buy.gif" border="0" /></a></div>
				  
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