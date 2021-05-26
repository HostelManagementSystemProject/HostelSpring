package com.mph.dao;

import java.util.List;

import com.mph.entity.Staff;

public interface StaffDao {
	public void createStaff(Staff staff);
	public List<Staff> getStaffList();
	public Staff getStaff(Staff staff);
	public List<Staff> updateStaff(Staff staff);
	public List<Staff> deleteStaff(int staff_id);
	public Staff searchStaff(int staff_id);
	public Staff getStaffById(int staff_id);
}
