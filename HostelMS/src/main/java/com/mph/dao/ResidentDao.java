package com.mph.dao;

import java.util.List;

import com.mph.entity.Resident;
import com.mph.entity.User;

public interface ResidentDao {
	public void createResident(Resident resident);
	public List<Resident> getResidentList();
	public Resident getResident(Resident resident);
	public List<Resident> updateResident(Resident resident);
	public List<Resident> deleteResident(int user_id);
	public Resident searchResident(int user_id);
	public Resident getResidentById(int user_id);
	public Resident getResidentEmail(String email_id, String password);
}
