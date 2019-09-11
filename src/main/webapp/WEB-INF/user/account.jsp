<html>
<body>
<%@ include file="../parts/common.jsp" %>
<div class="container" style="margin-top: 60px" xmlns="http://www.w3.org/1999/html">
    <div class="row">
        <div class="col-md-8 col-md-offset-2" style="padding-top: 50px">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" style="display: inline-block"> Replenishment</h3>
                </div>
                <div class="panel-body">
                    <form name="form" action="${pageContext.request.contextPath}/app/user/account" method="post" autocomplete="off" novalidate
                          ng-submit="form.$valid ">

                        <h4>Current balance: ${user.balance}</h4>
                        <div class="form-group">
                            <label id="replenishmentAmountLabel" for="replenishmentAmount"> Amount to replenish</label>
                            <input type="number"
                                   min="0.01"
                                   class="form-control"
                                   name="replenishmentAmount"
                                   id="replenishmentAmount"
                                   placeholder="100"
                                   required>
                            <div class="text-danger">
                                ${errorReplenishmentAmount}
                            </div>
                        </div>

                        <button type="submit" class="btn btn-success" style="margin-top:30px"
                                ng-disabled="form.$invalid">
                            Replenish
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>