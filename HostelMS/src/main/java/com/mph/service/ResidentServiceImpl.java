package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.ResidentDao;
import com.mph.entity.Resident;
import com.mph.entity.User;

@Service
@Transactional
public class ResidentServiceImpl implements ResidentService{
	
	@Autowired
	ResidentDao residentDao;
	
	
	/**
	 * This method is used to add resident
	 * @author Chandrika
	 * @param resident this is the parameter used to create resident
	 */
	@Override
	public void createResident(Resident resident) {
		residentDao.createResident(resident);
		
	}
	
	
	/**
	 * This method is used to get the list of residents
	 * @author Chandrika
	 * @param none no parameters are used in this method
	 * @return returns the list of residents
	 */
	@Override
	public List<Resident> getResidentList() {
		return residentDao.getResidentList();
	}
	
	
	/**
	 * This method is used to get any single resident based on ID
	 * @author Chandrika
	 * @param resident this is the parameter used to get a resident
	 * @return returns a specific resident
	 */
	@Override
	public Resident getResident(Resident resident) {
		return residentDao.getResident(resident);
	}
	
	/**
	 * This method is used to update the details of resident
	 * @author Chandrika
	 * @param resident this is the parameter used to get a resident
	 * @return returns the list of residents
	 */
	@Override
	public List<Resident> updateResident(Resident resident) {
		return residentDao.updateResident(resident);
	}
	
	
	/**
	 * This method is used to delete the resident based on ID
	 * @author Chandrika
	 * @param user_id this is the parameter used to delete the resident
	 * @return returns the list of residents
	 */
	@Override
	public List<Resident> deleteResident(int user_id) {
		return residentDao.deleteResident(user_id);
	}
	
	
	/**
	 * This method is used to search the resident based on ID
	 * @author Chandrika
	 * @param user_id this is the parameter used to search the resident
	 * @return returns a specific resident
	 */
	@Override
	public Resident searchResident(int user_id) {
		return residentDao.searchResident(user_id);
	}
	
	
	/**
	 * This method is used to get the resident based on ID
	 * @author Chandrika
	 * @param user_id this is the parameter used to get the resident
	 * @return returns a specific resident
	 */
	@Override
	public Resident getResidentById(int user_id) {
		return residentDao.getResidentById(user_id);
	}


	@Override
	public Resident getResidentEmail(String email_id, String password) {
		return residentDao.getResidentEmail(email_id,password);
	}

}
