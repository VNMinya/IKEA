<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
</head>
<body>
<div align="center">
	欢迎${u.uname}访问该系统。
	<h3 align="center">用户列表</h3>
	<table align="center" width="95%" border="1" cellpadding="2"	   cellspacing="1"	 >

		<!--   <table border="1"  width="30%" class="table table-striped table-bordered table-hover table-condensed"> -->
		<!-- 	<tr>
                  <td align="center" width="10px" nowrap>ID</td>
                <td align="center" width="50px" nowrap>用户名</td>
                <td align="center" width="50px" nowrap>年龄</td>
                <td align="center" width="80px" nowrap>地址</td>
                <td align="center" width="20px" nowrap>密码</td>
            </tr> -->
		<br>
		<div align="center">
			<form action="${pageContext.request.contextPath }/user/select" method="post">
			查找用户：<input type="text" name="uname"/> <br>
			<input type="submit" value="提交"/>
		</form>
		</div>

		<tr align="center">
			<th class="text-center">用户名称</th>
			<th class="text-center">用户性别</th>
			<th class="text-center">用户年龄</th>
			<th class="text-center">密码</th>
		</tr>
		<!--
		<s:iterator value="users">
			<tr>
				<td align="center"><s:property value="uname" /></td>
				<td align="center"><s:property value="usex" /></td>
				<td align="center"><s:property value="userage" /></td>
				<td align="center"><s:property value="password" /></td>
			</tr>
		</s:iterator>
		-->

		<c:forEach items="${userlist}" var="user">
			<tr>
				<td align="center">${user.uname}</td>
				<td align="center">${user.usex}</td>
				<td align="center">${user.userage}</td>
				<td align="center">${user.password}</td>
			</tr>
		</c:forEach>
	</table>

</div>
</body>
</html>