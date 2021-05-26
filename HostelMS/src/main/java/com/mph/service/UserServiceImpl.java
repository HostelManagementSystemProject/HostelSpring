package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.UserDao;
import com.mph.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	
	/**
	 * This method is used to create user
	 * @author Meghana
	 * @param user this is the parameter used to create user
	 */
	@Override
	public void createUser(User user) {
		userDao.createUser(user);
		
	}
	
	
	/**
	 * This method is used to get the list of users
	 * @author Meghana
	 * @param none no parameters are used in this method
	 * @return returns the list of users
	 */
	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}
	
	
	/**
	 * This method is used to get any single user based on ID
	 * @author Meghana
	 * @param user this is the parameter used to get an user
	 * @return returns a specific user
	 */
	@Override
	public User getUser(User user) {
		return userDao.getUser(user);
	}
	
	
	/**
	 * This method is used to update the details of user
	 * @author Meghana
	 * @param user this is the parameter used to get an user
	 * @return returns the list of users
	 */
	@Override
	public List<User> updateUser(User user) {
		return userDao.updateUser(user);
	}
	
	
	/**
	 * This method is used to delete the user based on ID
	 * @author Meghana
	 * @param user_id this is the parameter used to delete the user
	 * @return returns the list of users
	 */
	@Override
	public List<User> deleteUser(int user_id) {
		return userDao.deleteUser(user_id);
	}
	
	
	/**
	 * This method is used to search the user based on ID
	 * @author Meghana
	 * @param user_id this is the parameter used to search the user
	 * @return returns a specific user
	 */
	@Override
	public User searchUser(int user_id) {
		return userDao.searchUser(user_id);
	}
	
	
	/**
	 * This method is used to get the user based on email ID and password
	 * @author Meghana
	 * @param email_id password are the parameters used to get the user
	 * @return returns a specific user
	 */
	@Override
	public User getUserEmail(String email_id, String password) {
		return userDao.getUserEmail(email_id, password);
	}
	
	
	/**
	 * This method is used to get the user based on ID
	 * @author Meghana
	 * @param user_id this is the parameter used to get the user
	 * @return returns a specific user
	 */
	@Override
	public User getUserById(int user_id) {
		return userDao.getUserById(user_id);
	}

}
