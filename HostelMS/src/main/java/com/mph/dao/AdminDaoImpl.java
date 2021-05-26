package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Admin;
import com.mph.entity.Hostel;




@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * This method is used to add admin
	 * @author Kushdeep
	 * @param admin this is the parameter used to create admin
	 */
	
	@Override
	public void createAdmin(Admin admin) {
		getSession().saveOrUpdate(admin);
		System.out.println("Data Stored in DB Successfully...!!!");
		
	}
	
	/**
	 * This method is used to get the list of admins
	 * @author Kushdeep
	 * @param none no parameters are used in this method
	 * @return returns the list of admins
	 */
	
	@Override
	public List<Admin> getAdminList() {
		Query query = getSession().createQuery("select admins from ADMIN_HMS admins");
		List<Admin> adminlist=query.list();
		return adminlist;
	}
	
	/**
	 * This method is used to get any single admin based on ID
	 * @author Kushdeep
	 * @param admin this is the parameter used to get an admin
	 * @return returns a specific admin
	 */
	
	@Override
	public Admin getAdmin(Admin admin) {
		Criteria c=getSession().createCriteria(Admin.class);
		c.add(Restrictions.eq("admin_id",admin.getAdmin_id()));
		Admin admins=(Admin) c.uniqueResult();
		return admins;
	}
	
	/**
	 * This method is used to update the details of admin
	 * @author Kushdeep
	 * @param admin this is the parameter used to get an admin
	 * @return returns the list of admins
	 */
	
	@Override
	public List<Admin> updateAdmin(Admin admin) {
		Query query = getSession().createQuery("update ADMIN_HMS admin set email_id=:email_id,password=:password,phone_number=:phone_number where admin_id=:admin_id");
		query.setParameter("admin_id",admin.getAdmin_id());
		query.setParameter("email_id",admin.getEmail_id());
		query.setParameter("password",admin.getPassword());
		query.setParameter("phone_number",admin.getPhone_number());
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Updated successfully");
		}
		
		return getAdminList();
	}
	
	/**
	 * This method is used to delete the admin based on ID
	 * @author Kushdeep
	 * @param admin_id this is the parameter used to delete the admin
	 * @return returns the list of admins
	 */
	
	@Override
	public List<Admin> deleteAdmin(int admin_id) {
		Query query = getSession().createQuery("delete ADMIN_HMS admin where admin_id=:admin_id");
		query.setParameter("admin_id",admin_id);
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Deleted successfully");
		}
		
		return getAdminList();
	}
	
	/**
	 * This method is used to search the admin based on ID
	 * @author Kushdeep
	 * @param admin_id this is the parameter used to search the admin
	 * @return returns a specific admin
	 */
	
	@Override
	public Admin searchAdmin(int admin_id) {
		Criteria c=getSession().createCriteria(Admin.class);
		c.add(Restrictions.eq("admin_id",admin_id));
		Admin admin=(Admin) c.uniqueResult();
		return admin;
	}

	
	
}
