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

        <div class="panel-body">
            <form action="/ticket/pay" method="post" name="formTicket" style="margin: auto">
                <table class="table table-bordered  table-hover table-sm" style=" margin: auto;">
                    <tr>
                        <th>Passenger</th>
                        <th>Number</th>
                        <th>From/To</th>
                        <th>Departure/Arrival</th>
                        <th>Time</th>
                        <th>Price</th>
                    </tr>
                    <tr>
                        <td>
                            ${ticket.firstName} ${ticket.lastName}
                        </td>
<%--                        <td>${ticket.train.number}</td>--%>
<%--                        <td>${ticket.train.route.departure!}--%>
<%--                            <br>${ticket.train.route.arrival!}</td>--%>
<%--                        <td>${ticket.train.departureDate!}--%>
<%--                            <br>${ticket.train.arrivalDate!}</td>--%>
<%--                        <td> ${ticket.train.departureTime!}--%>
<%--                            <br>${ticket.train.arrivalTime!}</td>--%>
<%--                        <td> ${ticket.train.price!} UAH</td>--%>


                    </tr>
                </table>

                <p></p>
                <button type="submit">Pay</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
