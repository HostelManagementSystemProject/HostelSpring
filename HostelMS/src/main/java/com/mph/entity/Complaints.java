package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "COMPLAINTS_HMS")
public class Complaints {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complaintsseq")
	@SequenceGenerator(name = "complaintsseq", sequenceName = "complaintsseq", initialValue = 1, allocationSize = 100)
	private int complaint_id;

	private String complaint_name;

	private String particulars;

	private String status;

	public Complaints() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Complaints(int complaint_id, String complaint_name, String particulars, String status) {
		super();
		this.complaint_id = complaint_id;
		this.complaint_name = complaint_name;
		this.particulars = particulars;
		this.status = status;
	}

	public int getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(int complaint_id) {
		this.complaint_id = complaint_id;
	}

	public String getComplaint_name() {
		return complaint_name;
	}

	public void setComplaint_name(String complaint_name) {
		this.complaint_name = complaint_name;
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
		return "Complaints [complaint_id=" + complaint_id + ", complaint_name=" + complaint_name + ", particulars="
				+ particulars + ", status=" + status + "]";
	}

}
