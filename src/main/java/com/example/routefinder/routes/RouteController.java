package com.example.routefinder.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.routefinder.domain.Response;
import com.example.routefinder.user.User;

@RestController
@RequestMapping
public class RouteController {

	@Autowired  private RouteService routesService;
	
	@PostMapping("/route")
	public ResponseEntity <Response> postRoute(@RequestBody Route route ){
		try {
			Route dbRoute = routesService.save(route);
			if(dbRoute != null) {
				return new ResponseEntity<Response>(new Response( "Route is saved successfully" ), HttpStatus.OK);
			}
		}catch(Exception e) {

			return new ResponseEntity<Response>(new Response( "Route save failed due to: " + e), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Response>(new Response( "Route save failed" ), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getRoutes")
	public ResponseEntity <Response> getRoutes (@RequestBody User user){
		return null;
		
	}
	
}
