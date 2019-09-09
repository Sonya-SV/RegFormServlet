package com.training.regform.controller.command;

import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.Train;
import com.training.regform.model.entity.User;
import com.training.regform.model.service.TicketService;
import com.training.regform.model.service.TrainService;
import com.training.regform.model.service.UserService;
import jdk.swing.interop.SwingInterOpUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class OrderCommand implements Command {

    private TrainService trainService;

    public OrderCommand(TrainService trainService) {
        this.trainService = trainService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        Long trainId = Long.parseLong((request.getParameter("trainId")));

        Optional<Train> train = trainService.findById(trainId);

        System.out.println(trainId);

        train.ifPresent(value -> request.getSession().setAttribute("train", value));
        request.getSession().setAttribute("train", train.get());
        request.getSession().setAttribute("user", request.getSession().getAttribute("user"));
        System.out.println(train.get());

//        String trainId = request.getParameter("trainId");
//        if (firstName == null || firstName.equals("") || lastName == null || lastName.equals("")) {
//            return "/app/user/order.jsp";
//        }


        return "redirect:/app/user/cart.jsp";
    }
}

