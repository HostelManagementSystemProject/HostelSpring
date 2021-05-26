package com.mph.dao;

import java.util.List;

import com.mph.entity.Complaints;

public interface ComplaintsDao {
	public void createComplaint(Complaints complaint);
	public List<Complaints> getComplaintsList();
	public Complaints getComplaint(Complaints complaint);
	public List<Complaints> updateComplaint(Complaints complaint);
	public List<Complaints> deleteComplaint(int complaint_id);
	public Complaints searchComplaint(int complaint_id);
	public Complaints getComplaintById(int complaint_id);
}
