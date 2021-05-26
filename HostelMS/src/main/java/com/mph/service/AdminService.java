package com.mph.service;

import java.util.List;

import com.mph.entity.Admin;

public interface AdminService {
	public void createAdmin(Admin admin);
	public List<Admin> getAdminList();
	public Admin getAdmin(Admin admin);
	public List<Admin> updateAdmin(Admin admin);
	public List<Admin> deleteAdmin(int admin_id);
	public Admin searchAdmin(int admin_id);
}
