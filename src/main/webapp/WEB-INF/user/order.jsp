<html>
<body>
<%@ include file="../parts/common.jsp" %>
<div class="text-danger">
    ${noSeatsError}
</div>
<div class="col-md-6 col-md-offset-3" style="padding-top: 50px">
    <div class="panel panel-default">
        <div class=" panel-heading">
            <h3 class="panel-title" style="display: inline-block">Order</h3>
        </div>
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/app/user/cart">

                <div class="form-group">
                    <label id="exampleInputFirstNameLabel" for="firstName">First name</label>
                    <input type="text" value="${user.firstName}"
                           class="form-control"
                           name="firstName"
                           id="firstName"
                           placeholder=""
                           required>

                </div>

                <div class="form-group">
                    <label id="exampleInputLastNameLabel" for="lastName">Last name</label>
                    <input type="text" value="${user.lastName}"
                           class="form-control"
                           id="lastName"
                           name="lastName"
                           placeholder=""
                           required>
                </div>
                <table class="table table-bordered  table-hover table-sm" style=" margin: auto;">
                    <tr>
                        <th>Number</th>
                        <th>From/To</th>
                        <th>Departure/Arrival</th>
                        <th>Time</th>
                        <th>Price</th>
                    </tr>
                    <tr>
                        <td>${train.number}</td>
                        <td>${train.route.departure}
                            <br>${train.route.arrival}</td>
                        <td>${train.departureDate}
                            <br>${train.arrivalDate}</td>
                        <td> ${train.departureTime}
                            <br>${train.arrivalTime}</td>
                        <td> ${train.price} UAH</td>
                        <input type="hidden" value="${train.id}" name="trainId">
                    </tr>
                </table>
                <button type="submit" class="btn btn-primary" style="margin-top:30px"
                        ng-disabled="form.$invalid">
                    Add to ticket
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
