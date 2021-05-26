package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.ComplaintsDao;
import com.mph.entity.Complaints;

@Service
@Transactional
public class ComplaintsServiceImpl implements ComplaintsService{
	
	@Autowired
	ComplaintsDao complaintsDao;
	
	
	/**
	 * This method is used to create complaint
	 * @author Bhavana
	 * @param complaint this is the parameter used to create complaint
	 */
	@Override
	public void createComplaint(Complaints complaint) {
	complaintsDao.createComplaint(complaint);
		
	}
	
	
	/**
	 * This method is used to get the list of complaintss
	 * @author Bhavana
	 * @param none no parameters are used in this method
	 * @return returns the list of complaints
	 */
	@Override
	public List<Complaints> getComplaintsList() {
		return 	complaintsDao.getComplaintsList();
	
	}
	
	
	/**
	 * This method is used to get any single complaint based on ID
	 * @author Bhavana
	 * @param complaint this is the parameter used to get a complaint
	 * @return returns a specific complaint
	 */
	@Override
	public Complaints getComplaint(Complaints complaint) {
		return 	complaintsDao.getComplaint(complaint);
		
	}
	
	
	/**
	 * This method is used to update the details of complaint
	 * @author Bhavana
	 * @param complaint this is the parameter used to get a complaint
	 * @return returns the list of complaints
	 */
	@Override
	public List<Complaints> updateComplaint(Complaints complaint) {
		return 	complaintsDao.updateComplaint(complaint);
		
	}
	
	/**
	 * This method is used to delete the complaint based on ID
	 * @author Bhavana
	 * @param complaint_id this is the parameter used to delete the complaint
	 * @return returns the list of complaints
	 */
	@Override
	public List<Complaints> deleteComplaint(int complaint_id) {
		return complaintsDao.deleteComplaint(complaint_id);
		
	}
	
	
	/**
	 * This method is used to search the complaint based on ID
	 * @author Bhavana
	 * @param complaint_id this is the parameter used to search the complaint
	 * @return returns a specific complaint
	 */
	@Override
	public Complaints searchComplaint(int complaint_id) {
		return complaintsDao.searchComplaint(complaint_id);
	}
	
	
	/**
	 * This method is used to get the complaint based on ID
	 * @author Bhavana
	 * @param complaint_id this is the parameter used to search the complaint
	 * @return returns a specific complaint
	 */
	@Override
	public Complaints getComplaintById(int complaint_id) {
		return complaintsDao.getComplaintById(complaint_id);
	}

}
