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
	
	@Override
	public void createAdmin(Admin admin) {
		adminDao.createAdmin(admin);
		
	}

	@Override
	public List<Admin> getAdminList() {
		return adminDao.getAdminList();
	}

	@Override
	public Admin getAdmin(Admin admin) {
		return adminDao.getAdmin(admin);
	}

	@Override
	public List<Admin> updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}

	@Override
	public List<Admin> deleteAdmin(int admin_id) {
		return adminDao.deleteAdmin(admin_id);
	}

	@Override
	public Admin searchAdmin(int admin_id) {
		return adminDao.searchAdmin(admin_id);
	}

}
