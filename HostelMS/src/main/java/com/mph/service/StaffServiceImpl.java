package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.StaffDao;
import com.mph.entity.Staff;

@Service
@Transactional
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	StaffDao staffDao;
	
	
	/**
	 * This method is used to create staff
	 * @author Priya
	 * @param staff this is the parameter used to create staff
	 */
	@Override
	public void createStaff(Staff staff) {
		staffDao.createStaff(staff);
		
	}
	
	
	/**
	 * This method is used to get the list of staff
	 * @author Priya
	 * @param none no parameters are used in this method
	 * @return returns the list of staff
	 */
	@Override
	public List<Staff> getStaffList() {
		return staffDao.getStaffList();
	}
	
	
	/**
	 * This method is used to get any single staff based on ID
	 * @author Priya
	 * @param staff this is the parameter used to get a staff member
	 * @return returns a specific staff member
	 */
	@Override
	public Staff getStaff(Staff staff) {
		return staffDao.getStaff(staff);
	}
	
	
	/**
	 * This method is used to update the details of staff
	 * @author Priya
	 * @param staff this is the parameter used to get a staff member
	 * @return returns the list of staff
	 */
	@Override
	public List<Staff> updateStaff(Staff staff) {
		return staffDao.updateStaff(staff);
	}
	
	
	/**
	 * This method is used to delete the staff based on ID
	 * @author Priya
	 * @param user_id this is the parameter used to delete the staff
	 * @return returns the list of staff
	 */
	@Override
	public List<Staff> deleteStaff(int staff_id) {
		return staffDao.deleteStaff(staff_id);
	}
	
	
	/**
	 * This method is used to search the staff member based on ID
	 * @author Priya
	 * @param user_id this is the parameter used to search the staff member
	 * @return returns a specific staff member
	 */
	@Override
	public Staff searchStaff(int staff_id) {
		return staffDao.searchStaff(staff_id);
	}
	
	
	/**
	 * This method is used to get the staff member based on ID
	 * @author Priya
	 * @param user_id this is the parameter used to get the staff member
	 * @return returns a specific staff member
	 */
	@Override
	public Staff getStaffById(int staff_id) {
		return staffDao.getStaffById(staff_id);
	}

}
