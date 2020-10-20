package com.example.routefinder.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.routefinder.user.User;
import com.example.routefinder.user.UserRepository;



@Service("userDetailsService")
public class JwtUserDetailsServiceImpl implements UserDetailsService {


	 @Autowired private UserRepository userRepository;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with usernam '%s' .", username));
		}else {
			return JwtUserFactory.create(user);
		}
		
	}
}

