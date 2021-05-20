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
	
	@Override
	public void createHostel(Hostel hostel) {
		hostelDao.createHostel(hostel);
		
	}

	@Override
	public List<Hostel> getHostelList() {
		return hostelDao.getHostelList();
	}

	@Override
	public Hostel getHostel(Hostel hostel) {
		return hostelDao.getHostel(hostel);
	}

	@Override
	public List<Hostel> updateHostel(Hostel hostel) {
		return hostelDao.updateHostel(hostel);
	}

	@Override
	public List<Hostel> deleteHostel(int hostel_id) {
		return hostelDao.deleteHostel(hostel_id);
	}

}
