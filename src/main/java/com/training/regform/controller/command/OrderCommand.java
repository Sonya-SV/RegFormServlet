package com.training.regform.controller.command;

import com.training.regform.controller.exception.NoSeatsException;
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

    public static final String NO_SEATS = "No more seats";
    private TrainService trainService;

    public OrderCommand(TrainService trainService) {
        this.trainService = trainService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        Long trainId = Long.parseLong((request.getParameter("trainId")));

        Optional<Train> train = trainService.findById(trainId);

        train.ifPresent(value -> request.getSession().setAttribute("train", value));

        request.getSession().setAttribute("train", train.get());
        request.getSession().setAttribute("user", request.getSession().getAttribute("user"));
//        try{
//            trainService.bookTheSeat(train.get());
//        }catch (NoSeatsException e){
//            request.setAttribute("noSeatsError", NO_SEATS);
//            return "/app/user/order";
//        }
        return "redirect:/app/user/cart.jsp";
    }
}

