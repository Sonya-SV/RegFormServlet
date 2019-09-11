package com.training.regform.controller.command;

import com.training.regform.model.entity.User;
import com.training.regform.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class AccountCommand implements Command {
    public final static String positiveSum = "Enter the positive number";

    private UserService userService;

    public AccountCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        request.getSession().setAttribute("user", user);

        String sum = request.getParameter("replenishmentAmount");
        if (sum == null)
            return "/app/user/account.jsp";
        BigDecimal replenishmentAmount = new BigDecimal(sum);
        //todo REWRITE checking in command add delete from cart

        if (replenishmentAmount.compareTo(BigDecimal.ZERO) > 0)
            userService.updateAccount(user, replenishmentAmount);
        else
            request.setAttribute("errorReplenishmentAmount", positiveSum);
        return "/app/user/account.jsp";
    }
}
