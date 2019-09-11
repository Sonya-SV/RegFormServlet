<html>
<head>
    <title>Train selection</title>
</head>
<body>
<%@ include file="../parts/common.jsp" %>
<c:if test="${trains ne null}">

    <div class="card card-block text-xs-right">
        <h4 class="card-title"></h4>
        <p class="card-text"></p>
        <form name="form-inline" action="${pageContext.request.contextPath}/app/user/order" autocomplete="off"
              novalidate
              ng-submit="form.$valid ">
            <table class="table table-bordered  table-hover table-sm" style=" margin: auto;">
                <tr>
                    <th>Number</th>
                    <th>From/To</th>
                    <th>Departure/Arrival</th>
                    <th>Time</th>
                    <th>Free seats</th>
                    <th>Choose</th>
                </tr>
                <c:forEach items="${trains}" var="train">
                    <%--            --%>
                    <tr>
                        <td>${train.number}</td>
                        <td>${train.route.departure}
                            <br>${train.route.arrival}</td>
                        <td>${train.departureDate}
                            <br>${train.arrivalDate}</td>
                        <td> ${train.departureTime}
                            <br>${train.arrivalTime}</td>
                        <td> ${train.freeSeats}/${train.totalSeats}</td>
                        <td>
                                <%--                        <form name="form-inline" method="post" ng-submit="form.$valid ">--%>
                            <input type="hidden" value="${train.id}" name="trainId">
<%--                            <div class="qty mt-5">--%>
<%--                                <span class="minus bg-dark">-</span>--%>
<%--                                <input type="number" class="count" name="counter" min="1" max="${train.freeSeats}"--%>
<%--                                       value="1">--%>
<%--                                <span class="plus bg-dark">+</span>--%>
<%--                            </div>--%>

                            <button type="submit" class="btn btn-primary" style="margin-top:30px"
                                    ng-disabled="form.$invalid">
                                Choose
                            </button>
                                <%--                        </form>--%>
                        </td>

                    </tr>

                </c:forEach>
            </table>
                <%--        <a href="#" class="btn btn-primary">Go somewhere</a>--%>
        </form>
    </div>

</c:if>

</body>
</html>
