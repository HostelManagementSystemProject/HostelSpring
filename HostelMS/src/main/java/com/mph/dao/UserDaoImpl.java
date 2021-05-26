package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * This method is used to create user
	 * @author Meghana
	 * @param user this is the parameter used to create user
	 */
	@Override
	public void createUser(User user) {
		getSession().saveOrUpdate(user);
		System.out.println("Data Stored in DB Successfully...!!!");
	}
	
	/**
	 * This method is used to get the list of users
	 * @author Meghana
	 * @param none no parameters are used in this method
	 * @return returns the list of users
	 */
	@Override
	public List<User> getUserList() {
		Query query = getSession().createQuery("select users from USER_HMS users");
		List<User> userlist=query.list();
		return userlist;
	}
	
	/**
	 * This method is used to get any single user based on ID
	 * @author Meghana
	 * @param user this is the parameter used to get an user
	 * @return returns a specific user
	 */
	@Override
	public User getUser(User user) {
		Criteria c=getSession().createCriteria(User.class);
		c.add(Restrictions.eq("user_id",user.getUser_id()));
		User users=(User) c.uniqueResult();
		return users;
	}
	
	/**
	 * This method is used to update the details of user
	 * @author Meghana
	 * @param user this is the parameter used to get an user
	 * @return returns the list of users
	 */
	@Override
	public List<User> updateUser(User user) {
		System.out.println("from dao user " + user);
		Query query = getSession().createQuery("update USER_HMS user set user_name=:user_name,addressLine1=:addressLine1,addressLine2=:addressLine2,city=:city,state=:state,country=:country,zipCode=:zipCode,phone_number=:phone_number,email_id=:email_id,password=:password,gender=:gender,date_of_birth=:date_of_birth where user_id=:user_id");
		query.setParameter("user_id",user.getUser_id());
		query.setParameter("user_name",user.getUser_name());
		query.setParameter("addressLine1",user.getAddress().getAddressLine1());
		query.setParameter("addressLine2",user.getAddress().getAddressLine2());
		query.setParameter("city",user.getAddress().getCity());
		query.setParameter("state",user.getAddress().getState());
		query.setParameter("country",user.getAddress().getCountry());
		query.setParameter("zipCode",user.getAddress().getZipCode());
		query.setParameter("phone_number",user.getPhone_number());
		query.setParameter("email_id",user.getEmail_id());
		query.setParameter("password",user.getPassword());
		query.setParameter("gender",user.getGender());
		query.setParameter("date_of_birth",user.getDate_of_birth());
		//getSession().update(user);
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Updated successfully");
		}
		
		return getUserList();
	}
	
	
	/**
	 * This method is used to delete the user based on ID
	 * @author Meghana
	 * @param user_id this is the parameter used to delete the user
	 * @return returns the list of users
	 */
	@Override
	public List<User> deleteUser(int user_id) {
		Query query = getSession().createQuery("delete USER_HMS user where user_id=:user_id");
		query.setParameter("user_id",user_id);
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Deleted successfully");
		}
		
		return getUserList();
	}

	/**
	 * This method is used to search the user based on ID
	 * @author Meghana
	 * @param user_id this is the parameter used to search the user
	 * @return returns a specific user
	 */
	@Override
	public User searchUser(int user_id) {
		Criteria c=getSession().createCriteria(User.class);
		c.add(Restrictions.eq("user_id",user_id));
		User user=(User) c.uniqueResult();
		return user;
	}

	/**
	 * This method is used to get the user based on email ID and password
	 * @author Meghana
	 * @param email_id password are the parameters used to get the user
	 * @return returns a specific user
	 */
	@Override
	public User getUserEmail(String email_id,String password) {
		Criteria c=getSession().createCriteria(User.class);
		c.add(Restrictions.eq("email_id",email_id));
		c.add(Restrictions.eq("password",password));
		User users=(User) c.uniqueResult();
		return users;
	}

	
	/**
	 * This method is used to get the user based on ID
	 * @author Meghana
	 * @param user_id this is the parameter used to get the user
	 * @return returns a specific user
	 */
	@Override
	public User getUserById(int user_id) {
		Criteria c=getSession().createCriteria(User.class);
		c.add(Restrictions.eq("user_id",user_id));
		User user=(User) c.uniqueResult();
		return user;
	}

}
