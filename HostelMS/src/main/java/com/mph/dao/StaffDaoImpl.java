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

	@Override
	public void createStaff(Staff staff) {
		getSession().saveOrUpdate(staff);
		System.out.println("Data Stored in DB Successfully...!!!");
	}

	@Override
	public List<Staff> getStaffList() {
		Query query = getSession().createQuery("select staff from STAFF_HMS staff");
		List<Staff> stafflist=query.list();
		return stafflist;
	}

	@Override
	public Staff getStaff(Staff staff) {
		Criteria c=getSession().createCriteria(Staff.class);
		c.add(Restrictions.eq("staff_id",staff.getStaff_id()));
		Staff st=(Staff) c.uniqueResult();
		return st;
	}

	@Override
	public List<Staff> updateStaff(Staff staff) {
		System.out.println("from dao user " + staff);
		Query query = getSession().createQuery("update STAFF_HMS staff set staff_name=:staff_name,addressLine1=:addressLine1,addressLine2=:addressLine2,city=:city,state=:state,country=:country,zipCode=:zipCode,phone_number=:phone_number,email_id=:email_id,password=:password,gender=:gender,date_of_birth=:date_of_birth where staff_id=:staff_id");
		query.setParameter("staff_id",staff.getStaff_id());
		query.setParameter("staff_name",staff.getStaff_name());
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

	@Override
	public List<Staff> deleteStaff(int staff_id) {
		Query query = getSession().createQuery("delete STAFF_HMS staff where staff_id=:staff_id");
		query.setParameter("staff_id",staff_id);
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Deleted successfully");
		}
		
		return getStaffList();
	}

	@Override
	public Staff searchStaff(int staff_id) {
		Criteria c=getSession().createCriteria(Staff.class);
		c.add(Restrictions.eq("staff_id",staff_id));
		Staff staff=(Staff) c.uniqueResult();
		return staff;
	}

}