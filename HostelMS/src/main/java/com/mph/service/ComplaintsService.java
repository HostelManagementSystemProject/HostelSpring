package com.mph.service;

import java.util.List;

import com.mph.entity.Complaints;

public interface ComplaintsService {
	public void createComplaint(Complaints complaint);
	public List<Complaints> getComplaintsList();
	public Complaints getComplaint(Complaints complaint);
	public List<Complaints> updateComplaint(Complaints complaint);
	public List<Complaints> deleteComplaint(int complaint_id);
}
