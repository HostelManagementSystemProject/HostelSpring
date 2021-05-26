package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Hostel;

@Repository
public class HostelDaoImpl implements HostelDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * This method is used to add hostel
	 * @author Meghana
	 * @param hostel this is the parameter used to create hostel
	 */
	@Override
	public void createHostel(Hostel hostel) {
		getSession().saveOrUpdate(hostel);
		System.out.println("Data Stored in DB Successfully...!!!");
		
	}
	
	/**
	 * This method is used to get the list of hostels
	 * @author Meghana
	 * @param none no parameters are used in this method
	 * @return returns the list of hostels
	 */
	@Override
	public List<Hostel> getHostelList() {
		Query query = getSession().createQuery("select hostels from HOSTEL_HMS hostels");
		List<Hostel> hostellist=query.list();
		return hostellist;
	}
	
	/**
	 * This method is used to get any single hostel based on ID
	 * @author Meghana
	 * @param hostel this is the parameter used to get an hostel
	 * @return returns a specific hostel
	 */
	@Override
	public Hostel getHostel(Hostel hostel) {
		Criteria c=getSession().createCriteria(Hostel.class);
		c.add(Restrictions.eq("hostel_id",hostel.getHostel_id()));
		Hostel hostels=(Hostel) c.uniqueResult();
		return hostels;
	}
	
	/**
	 * This method is used to update the details of hostel
	 * @author Meghana
	 * @param admin this is the parameter used to get a hostel
	 * @return returns the list of hostels
	 */
	@Override
	public List<Hostel> updateHostel(Hostel hostel) {
		Query query = getSession().createQuery("update HOSTEL_HMS hostel set hostel_name=:hostel_name,hostel_address=:hostel_address,phone_number=:phone_number where hostel_id=:hostel_id");
		query.setParameter("hostel_id",hostel.getHostel_id());
		query.setParameter("hostel_name",hostel.getHostel_name());
		query.setParameter("hostel_address",hostel.getHostel_address());
		query.setParameter("phone_number",hostel.getPhone_number());
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Updated successfully");
		}
		
		return getHostelList();
	}

	/**
	 * This method is used to delete the hostel based on ID
	 * @author Meghana
	 * @param hostel_id this is the parameter used to delete the hostel
	 * @return returns the list of hostels
	 */
	@Override
	public List<Hostel> deleteHostel(int hostel_id) {
		Query query = getSession().createQuery("delete HOSTEL_HMS hostel where hostel_id=:hostel_id");
		query.setParameter("hostel_id",hostel_id);
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Deleted successfully");
		}
		
		return getHostelList();
	}
	
	/**
	 * This method is used to search the hostel based on ID
	 * @author Meghana
	 * @param hostel_id this is the parameter used to search the hostel
	 * @return returns a specific hostel
	 */
	@Override
	public Hostel searchHostel(int hostel_id) {
		Criteria c=getSession().createCriteria(Hostel.class);
		c.add(Restrictions.eq("hostel_id",hostel_id));
		Hostel hostel=(Hostel) c.uniqueResult();
		return hostel;
	}

	

}
