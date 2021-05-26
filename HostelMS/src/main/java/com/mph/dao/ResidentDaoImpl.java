package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Resident;
import com.mph.entity.User;

@Repository
public class ResidentDaoImpl implements ResidentDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * This method is used to add resident
	 * @author Chandrika
	 * @param resident this is the parameter used to create resident
	 */
	@Override
	public void createResident(Resident resident) {
		getSession().saveOrUpdate(resident);
		System.out.println("Resident stored successfully");
		
	}
	
	/**
	 * This method is used to get the list of residents
	 * @author Chandrika
	 * @param none no parameters are used in this method
	 * @return returns the list of residents
	 */
	@Override
	public List<Resident> getResidentList() {
		Query query = getSession().createQuery("select residents from RESIDENT_HMS residents");
		List<Resident> residentlist=query.list();
		return residentlist;
	}
	
	/**
	 * This method is used to get any single resident based on ID
	 * @author Chandrika
	 * @param resident this is the parameter used to get a resident
	 * @return returns a specific resident
	 */
	@Override
	public Resident getResident(Resident resident) {
		Criteria c=getSession().createCriteria(Resident.class);
		c.add(Restrictions.eq("user_id",resident.getUser_id()));
		Resident residents=(Resident) c.uniqueResult();
		return residents;
	}
	
	/**
	 * This method is used to update the details of resident
	 * @author Chandrika
	 * @param resident this is the parameter used to get a resident
	 * @return returns the list of residents
	 */
	@Override
	public List<Resident> updateResident(Resident resident) {
		Query query = getSession().createQuery("update RESIDENT_HMS resident set user_name=:user_name,addressLine1=:addressLine1,addressLine2=:addressLine2,city=:city,state=:state,country=:country,zipCode=:zipCode,phone_number=:phone_number,email_id=:email_id,password=:password,gender=:gender,date_of_birth=:date_of_birth,food_preferences=:food_preferences,room_no=:room_no where user_id=:user_id");
		query.setParameter("user_id",resident.getUser_id());
		query.setParameter("user_name",resident.getUser_name());
		query.setParameter("addressLine1",resident.getAddress().getAddressLine1());
		query.setParameter("addressLine2",resident.getAddress().getAddressLine2());
		query.setParameter("city",resident.getAddress().getCity());
		query.setParameter("state",resident.getAddress().getState());
		query.setParameter("country",resident.getAddress().getCountry());
		query.setParameter("zipCode",resident.getAddress().getZipCode());
		query.setParameter("phone_number",resident.getPhone_number());
		query.setParameter("email_id",resident.getEmail_id());
		query.setParameter("password",resident.getPassword());
		query.setParameter("gender",resident.getGender());
		query.setParameter("date_of_birth",resident.getDate_of_birth());
		query.setParameter("food_preferences",resident.getFood_preferences());
		query.setParameter("room_no",resident.getRoom());
		//getSession().update(user);
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Updated successfully");
		}
		
		return getResidentList();
	}
	
	/**
	 * This method is used to delete the resident based on ID
	 * @author Chandrika
	 * @param user_id this is the parameter used to delete the resident
	 * @return returns the list of residents
	 */
	@Override
	public List<Resident> deleteResident(int user_id) {
		Query query = getSession().createQuery("delete from RESIDENT_HMS resident where user_id=:user_id");
		query.setParameter("user_id",user_id);
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Deleted successfully");
		}
		
		return getResidentList();
	}
	
	/**
	 * This method is used to search the resident based on ID
	 * @author Chandrika
	 * @param user_id this is the parameter used to search the resident
	 * @return returns a specific resident
	 */
	@Override
	public Resident searchResident(int user_id) {
		Criteria c=getSession().createCriteria(Resident.class);
		c.add(Restrictions.eq("user_id",user_id));
		Resident resident=(Resident) c.uniqueResult();
		return resident;
	}
	
	/**
	 * This method is used to get the resident based on ID
	 * @author Chandrika
	 * @param user_id this is the parameter used to get the resident
	 * @return returns a specific resident
	 */
	@Override
	public Resident getResidentById(int user_id) {
		Criteria c=getSession().createCriteria(Resident.class);
		c.add(Restrictions.eq("user_id",user_id));
		Resident resident=(Resident) c.uniqueResult();
		return resident;
	}

	
	/**
	 * This method is used to get the resident based on email ID and password
	 * @author Chandrika
	 * @param email_id and password are the parameters used to get the resident
	 * @return returns a specific resident
	 */
	@Override
	public Resident getResidentEmail(String email_id, String password) {
		Criteria c=getSession().createCriteria(Resident.class);
		c.add(Restrictions.eq("email_id",email_id));
		c.add(Restrictions.eq("password",password));
		Resident r=(Resident) c.uniqueResult();
		return r;
	}

}
