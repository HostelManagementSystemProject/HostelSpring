package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="COMPLAINTS_HMS")
public class Complaints {
	@Id
	private int compliant_id;
	private String compliant_name;
	private String particulars;
	private String status;
	public Complaints() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Complaints(int compliant_id, String compliant_name, String particulars, String status) {
		super();
		this.compliant_id = compliant_id;
		this.compliant_name = compliant_name;
		this.particulars = particulars;
		this.status = status;
	}
	public int getCompliant_id() {
		return compliant_id;
	}
	public void setCompliant_id(int compliant_id) {
		this.compliant_id = compliant_id;
	}
	public String getCompliant_name() {
		return compliant_name;
	}
	public void setCompliant_name(String compliant_name) {
		this.compliant_name = compliant_name;
	}
	public String getParticulars() {
		return particulars;
	}
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Complaints [compliant_id=" + compliant_id + ", compliant_name=" + compliant_name + ", particulars="
				+ particulars + ", status=" + status + "]";
	}
	
	
}
