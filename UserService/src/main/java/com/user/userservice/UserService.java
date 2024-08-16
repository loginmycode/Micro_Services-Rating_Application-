package com.user.userservice;

import java.util.List;

import com.user.model.User;

public interface UserService {

	public User createUser(User user);
	
	public List<User> getAllUser();
	
	public User getSingleUser(String userId);
	
	
}
