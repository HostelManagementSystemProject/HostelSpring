package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.mph.dao.HostelDao;
import com.mph.entity.Hostel;

@Service
@Transactional
public class HostelServiceImpl implements HostelService{
	
	@Autowired
	HostelDao hostelDao;
	
	
	/**
	 * This method is used to add hostel
	 * @author Meghana
	 * @param hostel this is the parameter used to create hostel
	 */
	@Override
	public void createHostel(Hostel hostel) {
		hostelDao.createHostel(hostel);
		
	}
	
	
	/**
	 * This method is used to get the list of hostels
	 * @author Meghana
	 * @param none no parameters are used in this method
	 * @return returns the list of hostels
	 */
	@Override
	public List<Hostel> getHostelList() {
		return hostelDao.getHostelList();
	}
	
	
	/**
	 * This method is used to get any single hostel based on ID
	 * @author Meghana
	 * @param hostel this is the parameter used to get an hostel
	 * @return returns a specific hostel
	 */
	@Override
	public Hostel getHostel(Hostel hostel) {
		return hostelDao.getHostel(hostel);
	}
	
	
	/**
	 * This method is used to update the details of hostel
	 * @author Meghana
	 * @param admin this is the parameter used to get a hostel
	 * @return returns the list of hostels
	 */
	@Override
	public List<Hostel> updateHostel(Hostel hostel) {
		return hostelDao.updateHostel(hostel);
	}
	
	
	/**
	 * This method is used to delete the hostel based on ID
	 * @author Meghana
	 * @param hostel_id this is the parameter used to delete the hostel
	 * @return returns the list of hostels
	 */
	@Override
	public List<Hostel> deleteHostel(int hostel_id) {
		return hostelDao.deleteHostel(hostel_id);
	}
	
	
	/**
	 * This method is used to search the hostel based on ID
	 * @author Meghana
	 * @param hostel_id this is the parameter used to search the hostel
	 * @return returns a specific hostel
	 */
	@Override
	public Hostel searchHostel(int hostel_id) {
		return hostelDao.searchHostel(hostel_id);
	}

}
