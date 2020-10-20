package com.example.routefinder.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.routefinder.util.PasswordUtil;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired UserRepository userRepository;
	
	@Override
	public User save(User user) {
		String password = PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(password);
		
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return  (User) userRepository.findByEmail(email);
	}
}