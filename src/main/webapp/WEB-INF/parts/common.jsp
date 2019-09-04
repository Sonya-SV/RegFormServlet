<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body data-spy="scroll">
<div class="header">
    <div class="navbar-fixed-top">
        <div class="container">
            <div class="navbar navbar-default">
                <a class="navbar-brand" href="">MySite</a>
                <ul class="nav navbar-nav">

                    <%--                    <c:if test="${sessionScope.user.role eq ADMIN}">--%>
                    <%--                        <li><a href="${pageContext.request.contextPath}/app/userList">User List</a></li>--%>

                    <%--                    </c:if>--%>

                    <c:if test="${sessionScope.user.role eq GUEST}">
                        <li><a href="${pageContext.request.contextPath}/app/login">Login</a></li>
                        <li><a href="${pageContext.request.contextPath}/app/registration">Registration form</a></li>
                    </c:if>

                    <%--                    <li><a href="${pageContext.request.contextPath}/app/exception">Exception</a></li>--%>


                    <c:if test="${sessionScope.user.role ne GUEST}">
                        <li><a href="${pageContext.request.contextPath}/app/logout">Logout</a></li>
                    </c:if>

                    <c:if test="${sessionScope.user.role eq ADMIN}">
                        <li><a href="${pageContext.request.contextPath}/app/userList">User List</a></li>
                    </c:if>

                </ul>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</body>

</html>
