<%--
  Created by IntelliJ IDEA.
  User: Sonya
  Date: 03.09.2019
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html; charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Hello, user</title>
</head>
<body>
<%@ include file="../parts/common.jsp" %>
<div class="jumbotron" style="text-align: center">
    Hello, user
</div>
<c:out value="${sessionScope.username}"/>
</body>
</html>
