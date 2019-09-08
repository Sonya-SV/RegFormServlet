<html>
<head>
    <title>Train selection</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${trains ne null}">
    <div class="card card-block text-xs-right">
        <h4 class="card-title"></h4>
        <p class="card-text"></p>
    <table class="table table-bordered  table-hover table-sm" style=" margin: auto;">
    <tr>
        <th>Number</th>
        <th>From/To</th>
        <th>Departure/Arrival</th>
        <th>Time</th>
        <th>Free seats</th>
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
                <td>${train.freeSeats}/${train.totalSeats}
                    <a href="/tickets/${train.id}" class="btn btn-primary"> Choose</a>
                </td>
            </tr>

        </c:forEach>
    </table>
<%--        <a href="#" class="btn btn-primary">Go somewhere</a>--%>
    </div>
</c:if>

</body>
</html>
