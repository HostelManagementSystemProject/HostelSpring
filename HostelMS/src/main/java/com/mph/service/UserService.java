package com.mph.service;

import java.util.List;

import com.mph.entity.User;

public interface UserService {
	public void createUser(User user);
	public List<User> getUserList();
	public User getUser(User user);
	public List<User> updateUser(User user);
	public List<User> deleteUser(int user_id);
}
