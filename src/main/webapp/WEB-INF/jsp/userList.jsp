<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VN_Minya
  Date: 2019/4/4
  Time: 下午2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    用户信息<br>
    <c:forEach items="${userList}" var="user">
        ${user.uid} &nbsp;&nbsp;
        ${user.uname} &nbsp;&nbsp;
        ${user.usex}<br>
    </c:forEach>
</body>
</html>
