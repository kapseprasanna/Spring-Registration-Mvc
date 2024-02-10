package com.reglog.service;

import com.reglog.model.User;

public interface UserService {
	
	public User registerUser(User user);
	
	public boolean checkEmail(String string);

}
