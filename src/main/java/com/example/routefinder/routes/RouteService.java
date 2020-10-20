package com.example.routefinder.routes;

import java.util.List;



public interface RouteService {

	Route save(Route route) ;

	List<Route> findAll();

	Route getRouteByID(String name);
}
