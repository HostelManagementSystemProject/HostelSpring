package com.mph.dao;

import java.util.List;

import com.mph.entity.User;



public interface UserDao {
	public void createUser(User user);
	public List<User> getUserList();
	public User getUser(User user);
	public List<User> updateUser(User user);
	public List<User> deleteUser(int user_id);
	public User searchUser(int user_id);
}
