package com.training.regform.controller.command;

import com.training.regform.model.entity.Train;
import com.training.regform.model.service.TrainService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TrainChoose implements Command {
//    private TrainService trainService;
//
//    public TrainChoose(TrainService trainService) {
//        this.trainService = trainService;
//    }

    @Override
    public String execute(HttpServletRequest request) {

        String trainId = request.getParameter("trainId");
        System.out.println(trainId);
        return "redirect:/app/user/order";
    }
}
