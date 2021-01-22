package com.accolite.restapi.service;

import com.accolite.restapi.entity.User;

public interface UserService {

	public User addUser(User user);
	
	public User getUserById(Integer id);
	
	public User getUserByEmailId(String Email);
	
	public void deleteUser(Integer id);
}
