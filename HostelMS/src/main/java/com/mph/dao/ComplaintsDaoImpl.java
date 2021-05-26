package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Complaints;

@Repository
public class ComplaintsDaoImpl implements ComplaintsDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * This method is used to create complaint
	 * @author Bhavana
	 * @param complaint this is the parameter used to create complaint
	 */
	@Override
	public void createComplaint(Complaints complaint) {
		getSession().saveOrUpdate(complaint);
		System.out.println("Complaint stored in db successfully!:)");		
	}
	
	/**
	 * This method is used to get the list of complaintss
	 * @author Bhavana
	 * @param none no parameters are used in this method
	 * @return returns the list of complaints
	 */
	@Override
	public List<Complaints> getComplaintsList() {
		
		Query query=getSession().createQuery("select c from COMPLAINTS_HMS c");
		List<Complaints> complaint_list=query.list();
		System.out.println("complaints list: "+complaint_list);
		return complaint_list;
	}
	
	/**
	 * This method is used to get any single complaint based on ID
	 * @author Bhavana
	 * @param complaint this is the parameter used to get a complaint
	 * @return returns a specific complaint
	 */
	@Override
	public Complaints getComplaint(Complaints complaint) {
		Criteria c=getSession().createCriteria(Complaints.class);
		c.add(Restrictions.eq("complaint_id", complaint.getComplaint_id()));
		Complaints complaintInfo=(Complaints) c.uniqueResult();
		return complaintInfo;
	}
	
	/**
	 * This method is used to update the details of complaint
	 * @author Bhavana
	 * @param complaint this is the parameter used to get a complaint
	 * @return returns the list of complaints
	 */
	@Override
	public List<Complaints> updateComplaint(Complaints complaint) {
		Query query=getSession().createQuery("update COMPLAINTS_HMS set complaint_name=:complaint_name,particulars=:particulars,status=:status where complaint_id=:complaint_id");
		query.setParameter("complaint_name",complaint.getComplaint_name());
		query.setParameter("particulars", complaint.getParticulars());
		query.setParameter("status", complaint.getStatus());
		query.setParameter("complaint_id",complaint.getComplaint_id());
		int no_of_rows = query.executeUpdate();
		if(no_of_rows>0) {
			System.out.println("updated "+no_of_rows+ " of rows");
		}
		return getComplaintsList();
	}
	
	/**
	 * This method is used to delete the complaint based on ID
	 * @author Bhavana
	 * @param complaint_id this is the parameter used to delete the complaint
	 * @return returns the list of complaints
	 */
	@Override
	public List<Complaints> deleteComplaint(int complaint_id) {
		Query query=getSession().createQuery("delete from COMPLAINTS_HMS complaint where complaint_id=:complaint_id");
		query.setParameter("complaint_id", complaint_id);
		int no_of_rows = query.executeUpdate();
		if(no_of_rows>0) {
			System.out.println("deleted "+no_of_rows+" of rows");
		}
		
			
		return getComplaintsList();
		
	}
	
	/**
	 * This method is used to search the complaint based on ID
	 * @author Bhavana
	 * @param complaint_id this is the parameter used to search the complaint
	 * @return returns a specific complaint
	 */
	@Override
	public Complaints searchComplaint(int complaint_id) {
		Criteria c=getSession().createCriteria(Complaints.class);
		c.add(Restrictions.eq("complaint_id",complaint_id));
		Complaints complaint=(Complaints) c.uniqueResult();
		return complaint;
	}
	
	/**
	 * This method is used to get the complaint based on ID
	 * @author Bhavana
	 * @param complaint_id this is the parameter used to search the complaint
	 * @return returns a specific complaint
	 */
	@Override
	public Complaints getComplaintById(int complaint_id) {
		Criteria c=getSession().createCriteria(Complaints.class);
		c.add(Restrictions.eq("complaint_id",complaint_id));
		Complaints complaint=(Complaints) c.uniqueResult();
		return complaint;
	}
}
