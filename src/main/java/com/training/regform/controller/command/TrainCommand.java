package com.training.regform.controller.command;

import com.training.regform.model.entity.Route;
import com.training.regform.model.entity.Train;
import com.training.regform.model.entity.User;
import com.training.regform.model.service.TrainService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class TrainCommand implements Command {
    private TrainService trainService;

    public TrainCommand(TrainService trainService) {
        this.trainService = trainService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        if (isNull(request.getParameter("date")) || isNull(request.getParameter("time")))
            return "/app/user/trainselection.jsp";

        LocalDate date = LocalDate.parse(request.getParameter("date"));
        LocalTime time = LocalTime.parse(request.getParameter("time"));
        String departure = request.getParameter("departure");
        String arrival = request.getParameter("arrival");
//
//        Route route = new Route();
//        route.setDeparture(departure);
//        route.setArrival(arrival);
        List<Train> trains = trainService.getAllTrainsByRouteAndDateAndTime(date,time, departure, arrival);
        System.out.println(trains.get(0).getRoute().getArrival());
        if (!trains.isEmpty()) {
            request.setAttribute("trains", trains);
//            request.setAttribute("route", route);
        }
        return "/app/user/trainselection.jsp";

    }
}

