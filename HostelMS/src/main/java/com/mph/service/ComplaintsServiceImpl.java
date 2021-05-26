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
	
	@Override
	public void createComplaint(Complaints complaint) {
	complaintsDao.createComplaint(complaint);
		
	}

	@Override
	public List<Complaints> getComplaintsList() {
		return 	complaintsDao.getComplaintsList();
	
	}

	@Override
	public Complaints getComplaint(Complaints complaint) {
		return 	complaintsDao.getComplaint(complaint);
		
	}

	@Override
	public List<Complaints> updateComplaint(Complaints complaint) {
		return 	complaintsDao.updateComplaint(complaint);
		
	}

	@Override
	public List<Complaints> deleteComplaint(int complaint_id) {
		return complaintsDao.deleteComplaint(complaint_id);
		
	}

	@Override
	public Complaints searchComplaint(int complaint_id) {
		return complaintsDao.searchComplaint(complaint_id);
	}

	@Override
	public Complaints getComplaintById(int complaint_id) {
		return complaintsDao.getComplaintById(complaint_id);
	}

}
