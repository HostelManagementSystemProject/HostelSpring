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
	
	@Override
	public void createStaff(Staff staff) {
		staffDao.createStaff(staff);
		
	}

	@Override
	public List<Staff> getStaffList() {
		return staffDao.getStaffList();
	}

	@Override
	public Staff getStaff(Staff staff) {
		return staffDao.getStaff(staff);
	}

	@Override
	public List<Staff> updateStaff(Staff staff) {
		return staffDao.updateStaff(staff);
	}

	@Override
	public List<Staff> deleteStaff(int staff_id) {
		return staffDao.deleteStaff(staff_id);
	}

	@Override
	public Staff searchStaff(int staff_id) {
		return staffDao.searchStaff(staff_id);
	}

}
