<%--
  Created by IntelliJ IDEA.
  User: Sonya
  Date: 05.09.2019
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Train selection</title>
</head>
<body>
<%@ include file="../parts/common.jsp" %>
<div class="container" style="margin-top: 60px">
    <div class="row">
        <div class="col-md-6 col-md-offset-3" style="padding-top: 50px">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" style="display: inline-block">Select the train</h3>
                </div>
                <div class="panel-body">
                    <form name="form-inline" method="post" autocomplete="off" novalidate
                          ng-submit="form.$valid ">
                        <div class="form-group">
                            <label id="departureLabel">From</label>
                            <%--                                    <input type="text"--%>
                            <%--                                           class="form-control"--%>
                            <%--                                           name="departure"--%>
                            <%--                                           id="departure"--%>
                            <%--                                           placeholder=""--%>
                            <%--                                           value="Kyiv"--%>
                            <%--                                           required>--%>
                            <select name="departure" class="form-control form-control-lg">
                                <option ></option>
                                <option selected>Kyiv</option>
                                <option>Lviv</option>
                                <option>Vinnytsia</option>
                                <option>Chernivtsi</option>
                                <option>Kharkiv</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <%--                                    <label id="arrivalLabel" for="arrival"></label>--%>
                            <%--                                    <input type="text"--%>
                            <%--                                           class="form-control"--%>
                            <%--                                           id="arrival"--%>
                            <%--                                           name="arrival"--%>
                            <%--                                           placeholder="<@spring.message " arrival"/>"--%>
                            <%--                                    value="Cherkasy"--%>
                            <%--                                    required>--%>
                            <select name="arrival" class="form-control form-control-lg">
                                <option ></option>
                                <option >Kyiv</option>
                                <option>Lviv</option>
                                <option selected>Vinnytsia</option>
                                <option>Chernivtsi</option>
                                <option>Kharkiv</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label id="dateLabel">Departure date</label>
                            <input type="date" name="date" value="2019-10-02" max="2019-10-29" min="2019-09-28">
                        </div>
                        <div class="form-group">
                            <label id="timeLabel">Departure time</label>
                            <input class="form-control" type="time" name="time" value="00:00" id="example-time-input">
                        </div>

                        <button type="submit" class="btn btn-success" style="margin-top:30px"
                                ng-disabled="form.$invalid">
                            Find
                        </button>


                    </form>
                </div>
            </div>
        </div>
        <div class="container" style="padding-top: 10%">
            <div class="row">
                <div class="col-md-16 col-md-offset-1" style="padding-top: 50px">
                    <%@ include file="trainList.jsp" %>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
