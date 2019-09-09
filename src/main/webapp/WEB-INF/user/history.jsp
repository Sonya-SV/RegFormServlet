<html>
<body>
<%@ include file="../parts/common.jsp" %>
    <div class="container" style="margin-top: 60px" xmlns="http://www.w3.org/1999/html">
        <div class="row">
            <div class="col-md-8 col-md-offset-2" style="padding-top: 50px">
                <#include "common_profile.ftl">
                <#if tickets??>
                    <table class="table table-bordered  table-hover table-sm" style=" margin: auto;">
                        <tr>
                        <tr>
                            <th>Passenger</th>
                            <th>Number</th>
                            <th>From/To</th>
                            <th>Departure/Arrival</th>
                            <th>Time</th>
                        </tr>
                        </tr>
                            <tr>
                                <td>${ticket.firstname} ${ticket.lastName}
                                </td>
                                <td>${ticket.train.number}</td>
                                <td>${ticket.train.route.departure}
                                    <br>${ticket.train.route.arrival}
                                </td>
                                <td>${ticket.train.departureDate}
                                    <br>${ticket.train.arrivalDate}</td>
                                <td> ${ticket.train.departureTime}
                                    <br>${ticket.train.arrivalTime}</td>
                            </tr>

                    </table>

            </div>
        </div>
    </div>
</body>
</html>