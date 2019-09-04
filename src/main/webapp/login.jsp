<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
<%@ include file="WEB-INF/parts/common.jsp" %>
<div class="container" style="margin-top: 60px">
    <div class="row">
        <div class="col-md-6 col-md-offset-3" style="padding-top: 50px">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" style="display: inline-block">Login</h3>
                </div>
                <div class="panel-body">
                    <form method="post"
<%--                          action="${pageContext.request.contextPath}/app/"--%>
                    >

                        <div class="form-group">
                            <label id="usernameLabel" for="username">Username</label>
                            <input type="username"
                                   class="form-control"
                                   name="username"
                                   id="username"
                                   placeholder=""
                                   required/>

                        </div>
                        <div class="form-group">
                            <label id="passwordLabel" for="password">Password</label>
                            <input type="password"
                                   class="form-control"
                                   id="password"
                                   name="password"
                                   placeholder=""
                                   required/>

                        </div>
                        <button type="submit" class="btn btn-success" style="margin-top:30px"
                                ng-disabled="form.$invalid">
                            Log in
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>