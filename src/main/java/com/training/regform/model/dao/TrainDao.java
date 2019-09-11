package com.training.regform.model.dao;

import com.training.regform.model.entity.Route;
import com.training.regform.model.entity.Train;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface TrainDao extends GenericDao<Train> {
    List<Train> findByRouteAndDateAndTime(LocalDate date, LocalTime time, String departure, String arrival);


}
