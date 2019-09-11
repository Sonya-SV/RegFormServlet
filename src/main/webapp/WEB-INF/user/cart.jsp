<html>
<head>
    <title>Train selection</title>
</head>
<body>
<%@ include file="../parts/common.jsp" %>
<div class="col-md-10 col-md-offset-1" style="padding-top: 10%">
    <div class="panel panel-default">
        <div class=" panel-heading">
            <h3 class="panel-title" style="display: inline-block">Cart</h3>
        </div>

        <c:if test="${emptyCart ne null}">
            <div class="jumbotron" style="text-align: center; background: transparent">
                ${emptyCart}
            </div>
        </c:if>
        <c:if test="${ticket ne null}">
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/app/user/cart" method="post" name="formTicket"
                  style="margin: auto">

                <table class="table table-bordered  table-hover table-sm" style=" margin: auto;">
                    <tr>
                        <th>Passenger</th>
                        <th>Number</th>
                        <th>From/To</th>
                        <th>Departure/Arrival</th>
                        <th>Time</th>
                        <th>Price</th>
                        <th>Delete</th>
                    </tr>
                    <tr>
                        <td>
                            ${ticket.firstName} ${ticket.lastName}
                        </td>
                        <td>${ticket.train.number}</td>
                        <td>${ticket.train.route.departure}
                            <br>${ticket.train.route.arrival}</td>
                        <td>${ticket.train.departureDate}
                            <br>${ticket.train.arrivalDate}</td>
                        <td> ${ticket.train.departureTime}
                            <br>${ticket.train.arrivalTime}</td>
                        <td> ${ticket.train.price} UAH</td>
                        <td>
                            Delete
                        </td>

                    </tr>
                </table>

                <div class="text-danger">
                    <c:if test="${errorPay ne null}">
                        ${errorPay}
                    </c:if>
                </div>
                <a type="submit">
                <button class="btn btn-primary">Pay</button>
                </a>

            </form>
        </div>
        </c:if>
    </div>
</div>
</body>
</html>
