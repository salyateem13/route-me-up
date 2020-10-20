package com.example.routefinder.routes;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.routefinder.user.User;

@Repository
public interface RouteRepository extends CrudRepository<Route,Long>{

	List<Route> findRoutesByUser(User user);
}
