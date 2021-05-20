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
	
	@Override
	public void createAdmin(Admin admin) {
		getSession().saveOrUpdate(admin);
		System.out.println("Data Stored in DB Successfully...!!!");
		
	}

	@Override
	public List<Admin> getAdminList() {
		Query query = getSession().createQuery("select admins from ADMIN_HMS admins");
		List<Admin> adminlist=query.list();
		return adminlist;
	}

	@Override
	public Admin getAdmin(Admin admin) {
		Criteria c=getSession().createCriteria(Admin.class);
		c.add(Restrictions.eq("admin_id",admin.getAdmin_id()));
		Admin admins=(Admin) c.uniqueResult();
		return admins;
	}

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

	@Override
	public Admin searchAdmin(int admin_id) {
		Criteria c=getSession().createCriteria(Admin.class);
		c.add(Restrictions.eq("admin_id",admin_id));
		Admin admin=(Admin) c.uniqueResult();
		return admin;
	}

}
