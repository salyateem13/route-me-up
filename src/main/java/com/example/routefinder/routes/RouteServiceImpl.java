package com.example.routefinder.routes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.routefinder.user.User;
import com.example.routefinder.user.UserRepository;

@Service 
@Transactional
public class RouteServiceImpl implements RouteService{

	@Autowired RouteRepository routeRepository;

	@Override
	public Route save(Route route) {
		// TODO Auto-generated method stub
		
		return routeRepository.save(route);
	}

	@Override
	public List<Route> findAll() {
		// TODO Auto-generated method stub
		return (List<Route>) routeRepository.findAll();
	}

	@Override
	public Route getRouteByID(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
