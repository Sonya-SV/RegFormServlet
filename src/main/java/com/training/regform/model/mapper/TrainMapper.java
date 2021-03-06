package com.training.regform.model.mapper;

import com.training.regform.model.entity.Route;
import com.training.regform.model.entity.Train;
import com.training.regform.model.entity.User;

import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TrainMapper implements ObjectMapper<Train>{

    private RouteMapper routeMapper;

    public TrainMapper(RouteMapper routeMapper) {
        this.routeMapper = routeMapper;
    }

    @Override
    public Train extractFromResultSet(ResultSet rs) throws SQLException {
        Train train = new Train();
        train.setId(rs.getLong("id"));
        train.setNumber(rs.getString("number"));
        train.setDepartureDate(rs.getDate("departure_date").toLocalDate());
        train.setArrivalDate(rs.getDate("arrival_date").toLocalDate());
        train.setDepartureTime(rs.getTime("departure_time").toLocalTime());
        train.setArrivalTime(rs.getTime("arrival_time").toLocalTime());
        train.setFreeSeats(rs.getInt("free_seats"));
        train.setTotalSeats(rs.getInt("total_seats"));
        train.setPrice(rs.getBigDecimal("price"));

        Route route = new Route();
        route.setArrival(rs.getString("arrival"));
        route.setDeparture(rs.getString("departure"));
        route.setId(rs.getLong("route_id"));

        train.setRoute(route);

        return train;
    }

}
