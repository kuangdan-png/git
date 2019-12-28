<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="#" method="post">
			注册手机号:<input type="text" name="regtelenumber" id="txtregtele"/><br/>
			<c:if test="${sessionScope.MESSAGE ne null}">
				<font color="red">${sessionScope.MESSAGE}</font>
			</c:if>
			<br/>
			注册验证码:<input type="text" name="regtelecode"/><br/>
			<input type="submit" value="注册提交"/>
		</form>
	</center>
	<script type="text/javascript">
		//1、给注册手机号的文本框对象添加一个id属性，再根据id的值获取当前文本框对象
		var txtTelObj = document.getElementById("txtregtele");
		//2、给当前文本框对象注册失去焦点的事件
		txtTelObj.onblur=function(){
			//3、基于文本框对象获取值(value)		
			var teleValueStr = txtTelObj.value;
			//4、提交至servlet
			window.location.href="../registerTeleServlet?telenumber=" + teleValueStr;
		}
	</script>
</body>
</html>