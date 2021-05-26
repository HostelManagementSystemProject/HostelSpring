package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Staff;

@Repository
public class StaffDaoImpl implements  StaffDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * This method is used to create staff
	 * @author Priya
	 * @param staff this is the parameter used to create staff
	 */
	@Override
	public void createStaff(Staff staff) {
		getSession().saveOrUpdate(staff);
		System.out.println("Data Stored in DB Successfully...!!!");
	}
	
	/**
	 * This method is used to get the list of staff
	 * @author Priya
	 * @param none no parameters are used in this method
	 * @return returns the list of staff
	 */
	@Override
	public List<Staff> getStaffList() {
		Query query = getSession().createQuery("select staff from STAFF_HMS staff");
		List<Staff> stafflist=query.list();
		return stafflist;
	}
	
	/**
	 * This method is used to get any single staff based on ID
	 * @author Priya
	 * @param staff this is the parameter used to get a staff member
	 * @return returns a specific staff member
	 */
	@Override
	public Staff getStaff(Staff staff) {
		Criteria c=getSession().createCriteria(Staff.class);
		c.add(Restrictions.eq("user_id",staff.getUser_id()));
		Staff st=(Staff) c.uniqueResult();
		return st;
	}
	
	/**
	 * This method is used to update the details of staff
	 * @author Priya
	 * @param staff this is the parameter used to get a staff member
	 * @return returns the list of staff
	 */
	@Override
	public List<Staff> updateStaff(Staff staff) {
		System.out.println("from dao user " + staff);
		Query query = getSession().createQuery("update STAFF_HMS staff set user_name=:user_name,addressLine1=:addressLine1,addressLine2=:addressLine2,city=:city,state=:state,country=:country,zipCode=:zipCode,phone_number=:phone_number,email_id=:email_id,password=:password,gender=:gender,date_of_birth=:date_of_birth where user_id=:user_id");
		query.setParameter("user_id",staff.getUser_id());
		query.setParameter("user_name",staff.getUser_name());
		query.setParameter("addressLine1",staff.getAddress().getAddressLine1());
		query.setParameter("addressLine2",staff.getAddress().getAddressLine2());
		query.setParameter("city",staff.getAddress().getCity());
		query.setParameter("state",staff.getAddress().getState());
		query.setParameter("country",staff.getAddress().getCountry());
		query.setParameter("zipCode",staff.getAddress().getZipCode());
		query.setParameter("phone_number",staff.getPhone_number());
		query.setParameter("email_id",staff.getEmail_id());
		query.setParameter("password",staff.getPassword());
		query.setParameter("gender",staff.getGender());
		query.setParameter("date_of_birth",staff.getDate_of_birth());
		//getSession().update(user);
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Updated successfully");
		}
		
		return getStaffList();
	}
	
	/**
	 * This method is used to delete the staff based on ID
	 * @author Priya
	 * @param user_id this is the parameter used to delete the staff
	 * @return returns the list of staff
	 */
	@Override
	public List<Staff> deleteStaff(int user_id) {
		Query query = getSession().createQuery("delete STAFF_HMS staff where user_id=:user_id ");
		query.setParameter("user_id",user_id);
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Deleted successfully");
		}
		
		return getStaffList();
	}

	/**
	 * This method is used to search the staff member based on ID
	 * @author Priya
	 * @param user_id this is the parameter used to search the staff member
	 * @return returns a specific staff member
	 */
	@Override
	public Staff searchStaff(int user_id) {
		Criteria c=getSession().createCriteria(Staff.class);
		c.add(Restrictions.eq("user_id",user_id));
		Staff staff=(Staff) c.uniqueResult();
		return staff;
	}
	
	/**
	 * This method is used to get the staff member based on ID
	 * @author Priya
	 * @param user_id this is the parameter used to get the staff member
	 * @return returns a specific staff member
	 */
	@Override
	public Staff getStaffById(int user_id) {
		Criteria c=getSession().createCriteria(Staff.class);
		c.add(Restrictions.eq("user_id",user_id));
		Staff staff=(Staff) c.uniqueResult();
		return staff;
	}

}
