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
<%--    <link rel="stylesheet" href= "${pageContext.request.contextPath}/app/resources/css/index.css" />--%>
    <style>
<%--    <%@ include file="../lib/css/index.css" %>--%>
    </style>
</head>
<body data-spy="scroll">
<div class="header">
    <div class="navbar-fixed-top">
        <div class="container">
            <div class="navbar navbar-default">
                <a class="navbar-brand" href="">MySite</a>
                <ul class="nav navbar-nav">

<%--                    <c:if test="${sessionScope.user.role eq ADMIN}">--%>
                        <li><a href="${pageContext.request.contextPath}/app/admin/userList">User List</a></li>
                        <li><a href="${pageContext.request.contextPath}/app/user/trainSelection">Train tickets</a></li>
<%--                    </c:if>--%>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${sessionScope.user.role eq GUEST}">
                        <li><a href="${pageContext.request.contextPath}/app/login">
                            <span class="glyphicon glyphicon-log-in"></span> Login </a></li>
                        <li><a href="${pageContext.request.contextPath}/app/registration">
                            <span class="glyphicon glyphicon-user"></span> Sign up </a></li>
                    </c:if>
                    <c:if test="${sessionScope.user.role ne GUEST}">
                        <li><a><span class="glyphicon glyphicon-user"></span> ${sessionScope.user.username}</a></li>
                        <li><a href="${pageContext.request.contextPath}/app/logout"><span
                                class="glyphicon glyphicon-log-out"></span> Logout </a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</body>

</html>
