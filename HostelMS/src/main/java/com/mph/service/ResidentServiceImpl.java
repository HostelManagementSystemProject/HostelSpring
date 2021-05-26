package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.ResidentDao;
import com.mph.entity.Resident;

@Service
@Transactional
public class ResidentServiceImpl implements ResidentService{
	
	@Autowired
	ResidentDao residentDao;
	
	@Override
	public void createResident(Resident resident) {
		residentDao.createResident(resident);
		
	}

	@Override
	public List<Resident> getResidentList() {
		return residentDao.getResidentList();
	}

	@Override
	public Resident getResident(Resident resident) {
		return residentDao.getResident(resident);
	}

	@Override
	public List<Resident> updateResident(Resident resident) {
		return residentDao.updateResident(resident);
	}

	@Override
	public List<Resident> deleteResident(int user_id) {
		return residentDao.deleteResident(user_id);
	}

	@Override
	public Resident searchResident(int user_id) {
		return residentDao.searchResident(user_id);
	}

	@Override
	public Resident getResidentById(int user_id) {
		return residentDao.getResidentById(user_id);
	}

	@Override
	public Resident getResidentEmail(String email_id, String password) {
		return residentDao.getResidentEmail(email_id,password);
	}
}
