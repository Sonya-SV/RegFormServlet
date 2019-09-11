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
        if (isNull(request.getParameter("departure")))
            return "/app/user/trainSelection";

        LocalDate date = LocalDate.parse(request.getParameter("date"));
        LocalTime time = LocalTime.parse(request.getParameter("time"));
        String departure = request.getParameter("departure");
        String arrival = request.getParameter("arrival");

        List<Train> trains = trainService.getAllTrainsByRouteAndDateAndTime(date, time, departure, arrival);
        if (!trains.isEmpty()) {
            request.setAttribute("trains", trains);
            return "/app/user/order.jsp";
        }

        return "/app/user/trainSelection";
    }
}

