package com.training.regform.model.mapper;

import com.training.regform.model.entity.Route;
import com.training.regform.model.entity.Train;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteMapper implements ObjectMapper<Route> {

    @Override
    public Route extractFromResultSet(ResultSet rs) throws SQLException {
        Route route = new Route();
        route.setId(rs.getLong("id"));
        route.setArrival(rs.getString("arrival"));
        route.setDeparture(rs.getString("departure"));
        return route;
    }
}
