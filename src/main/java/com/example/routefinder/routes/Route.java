package com.example.routefinder.routes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.maps.model.DirectionsResult;
import com.example.routefinder.user.User;


@Entity
@Table (name="route")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(nullable = false, updatable = true, unique = true)
//	private String routeName;
//	
//	
//	//route type: Circle or straight route
//	@Column
//	private String routeType;
//	
	
	//Direction for route
	@Column
	private Object dirResult;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id", nullable = true)
	private User user;

	public Route(Long id, DirectionsResult dirResult, User user) {
		super();
		this.id = id;
		this.dirResult = dirResult;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public Object getDirResult() {
		return dirResult;
	}

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDirResult(DirectionsResult dirResult) {
		this.dirResult = dirResult;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
