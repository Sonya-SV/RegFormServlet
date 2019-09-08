package com.training.regform.controller.command;

import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.Train;
import com.training.regform.model.entity.User;
import com.training.regform.model.service.TicketService;
import com.training.regform.model.service.TrainService;
import com.training.regform.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class OrderCommand implements Command {

    private TrainService trainService;

    public OrderCommand(TrainService trainService) {
        this.trainService = trainService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
//        Long trainId = Long.parseLong((request.getParameter("trainId")));
//        String trainId = request.getParameter("trainId");
        if (firstName == null || firstName.equals("") || lastName == null || lastName.equals("")) {
            return "/app/user/order.jsp";
        }

        System.out.println("name = " + firstName + lastName);
//        System.out.println("trainID= " + trainId);
//        Long id = Long.valueOf(trainId);
////        Optional<Train> train = trainService.findById(id);
//        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
//        request.getSession().setAttribute("ticket", ticket);
//        if(ticket == null){
//            ticket = new Ticket();
////            ticket.setTrain(request.getPa);
//            ticket.setFirstName(request.getParameter("firstName"));
//            ticket.setLastName(request.getParameter("lastName"));
////            ticket.setTrain((Train) request.getSession().getAttribute("train"));
////            ticket.setUser((User) request.getSession().getAttribute("user"));
//        }
//        request.getSession().getAttribute("ticket");
        User user = (User) request.getSession().getAttribute("user");
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("train", request.getSession().getAttribute("train"));
        return "redirect:/app/user/cart.jsp";
    }
}

