package com.mph.dao;

import java.util.List;

import com.mph.entity.Hostel;

public interface HostelDao {
	public void createHostel(Hostel hostel);
	public List<Hostel> getHostelList();
	public Hostel getHostel(Hostel hostel);
	public List<Hostel> updateHostel(Hostel hostel);
	public List<Hostel> deleteHostel(int hostel_id);
}
