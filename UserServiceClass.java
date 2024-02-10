package com.reglog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reglog.model.User;
import com.reglog.repository.UserRepository;

@Service
public class UserServiceClass implements UserService    {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User registerUser(User user) {
		
		return repository.save(user);
	}

	@Override
	public boolean checkEmail(String email) {
		
		return repository.existsByEmail(email);
	}
	
	
	

}
