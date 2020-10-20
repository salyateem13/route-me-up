package com.example.routefinder.domain;

import java.io.Serializable;

import com.example.routefinder.user.User;


public class UserDTO implements Serializable {
	

	private User user;
	private String token;
	public UserDTO(User user, String token) {
		super();
		this.user = user;
		this.token= token;
	}
	public User getUser() {
		return user;
	}
	public String getToken() {
		return token;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setToken(String token) {
		this.token = token;
	}
}