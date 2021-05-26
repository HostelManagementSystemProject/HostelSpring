package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.AdminDao;
import com.mph.entity.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDao adminDao;
	
	/**
	 * This method is used to create admin
	 * @author Kushdeep
	 * @param admin this is the parameter used to create admin
	 */
	@Override
	public void createAdmin(Admin admin) {
		adminDao.createAdmin(admin);
		
	}
	
	/**
	 * This method is used to get any single admin based on ID
	 * @author Kushdeep
	 * @param admin this is the parameter used to get an admin
	 * @return returns a specific admin
	 */
	@Override
	public Admin getAdmin(Admin admin) {
		return adminDao.getAdmin(admin);
	}
	
	/**
	 * This method is used to update the details of admin
	 * @author Kushdeep
	 * @param admin this is the parameter used to get an admin
	 * @return returns the list of admins
	 */
	@Override
	public List<Admin> updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}
	
	/**
	 * This method is used to search the admin based on ID
	 * @author Kushdeep
	 * @param admin_id this is the parameter used to search the admin
	 * @return returns a specific admin
	 */
	@Override
	public Admin searchAdmin(int admin_id) {
		return adminDao.searchAdmin(admin_id);
	}
	
	/**
	 * This method is used to get the list of admins
	 * @author Kushdeep
	 * @param none no parameters are used in this method
	 * @return returns the list of admins
	 */
	@Override
	public List<Admin> getAdminList() {
		return adminDao.getAdminList();
	}
	
	/**
	 * This method is used to delete the admin based on ID
	 * @author Kushdeep
	 * @param admin_id this is the parameter used to delete the admin
	 * @return returns the list of admins
	 */
	@Override
	public List<Admin> deleteAdmin(int admin_id) {
		return adminDao.deleteAdmin(admin_id);
	}

}
