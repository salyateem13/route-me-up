package com.example.routefinder.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.routefinder.routes.Route;


@Entity
@Table (name="user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3009157732242241606L;

	@Id
	@GeneratedValue(strategy = 	GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(nullable = false, updatable = true, unique = true)
	private String email;
	
	@Column (name = "Password")
	private String password;
	
	@Column(name = "FirstName", nullable = true)
	private String firstName;
	
	@Column(name = "lastname", nullable = true)
	private String lastName;
	
	@OneToMany(mappedBy = "user")
	private List <Route> routes = new ArrayList<Route>();
	

	public User() {
		super();
	}

	public User(Long id, @NotNull String username, String password, String firstName, String lastName,
			String email) {
		super();
		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public Long getId() {
		return id;
	}




	public String getPassword() {
		return password;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setId(Long id) {
		this.id = id;
	}





	public void setPassword(String password) {
		this.password = password;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
