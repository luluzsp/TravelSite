<%--
  Created by IntelliJ IDEA.
  User: Tony_Zhou
  Date: 2019/11/21
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/product/findAll">旅行网主页</a></h1>
<jsp:forward page="pages/main.jsp"></jsp:forward>
</body>
</html>
