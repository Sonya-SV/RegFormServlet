<html>
<head>
    <title>Registration form</title>

</head>
<body>
<%@ include file="WEB-INF/parts/common.jsp" %>

<div class="container" style="margin-top: 60px">
    <div class="row">
        <div class="col-md-6 col-md-offset-3" style="padding-top: 50px">
            <div class="panel panel-default">
                <div class=" panel-heading">
                    <h3 class="panel-title" style="display: inline-block">Registration</h3>
                </div>
                <div class="panel-body">
                    <h3 style="color: red"></h3>
                    <form method="post" autocomplete="off" novalidate
                          ng-submit="form.$valid ">

                        <div class="form-group">
                            <label id="usernameLabel" for="username"> Username</label>
                            <input type="text" value=""
                                   class="form-control"
                                   name="username"
                                   id="username"
                                   placeholder=""/>
                        </div>
                        <div class="form-group">
                            <label id="exampleInputFirstNameLabel" for="firstName">First Name</label>
                            <input type="text" value=""
                                   class="form-control"
                                   name="firstName"
                                   id="firstName"
                                   placeholder="">
                        </div>
                        <div class="form-group">
                            <label id="exampleInputLastNameLabel" for="lastName">Last name</label>
                            <input type="text" value=""
                                   class="form-control"
                                   id="lastName"
                                   name="lastName"
                                   placeholder="">
                        </div>
                        <div class="form-group">
                            <label id="passwordLabel" for="password">Password</label>
                            <input type="password"
                                   class="form-control"
                                   id="password"
                                   name="password"
                                   placeholder=""/>

                        </div>
                        <%--    <div class="form-group">--%>
                        <%--        <label id="password2Label" for="password2">Password2</label>--%>
                        <%--        <input type="password"--%>
                        <%--               class="form-control"--%>
                        <%--               id="password2"--%>
                        <%--               name="password2"--%>
                        <%--               placeholder=""--%>
                        <%--               required>--%>
                        <%--        <div class="text-danger">--%>
                        <%--</div>--%>

<%--                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>--%>
                        <button type="submit" class="btn btn-success" style="margin-top:30px">
                            Registration
                        </button>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>