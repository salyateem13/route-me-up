package com.example.routefinder.user;

import java.util.List;


public interface UserService {
	
	User save(User user) ;

	List<User> findAll();

	User getUserByEmail(String name);

}
