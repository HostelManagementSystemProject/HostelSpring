package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "COMPLAINTS_HMS")
public class Complaints {
	
	
	/**
	 * The complaint Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complaintsseq")
	@SequenceGenerator(name = "complaintsseq", sequenceName = "complaintsseq", initialValue = 1, allocationSize = 100)
	private int complaint_id;
	
	
	/**
	 * The complaint name
	 */
	private String complaint_name;
	
	
	/**
	 * The particulars
	 */
	private String particulars;
	
	
	/**
	 * The status
	 */
	private String status;
	
	
	/**
	 * Instantiates a new address
	 */
	public Complaints() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Instantiates a new address
	 * @param complaint_id
	 * @param complaint_name
	 * @param particulars
	 * @param status
	 */
	public Complaints(int complaint_id, String complaint_name, String particulars, String status) {
		super();
		this.complaint_id = complaint_id;
		this.complaint_name = complaint_name;
		this.particulars = particulars;
		this.status = status;
	}
	
	
	/**
	 * gets the complaint_id
	 * @return complaint_id
	 */
	public int getComplaint_id() {
		return complaint_id;
	}
	
	
	/**
	 * sets the complaint_id
	 * @param complaint_id
	 */
	public void setComplaint_id(int complaint_id) {
		this.complaint_id = complaint_id;
	}
	
	
	/**
	 * gets the complaint_name
	 * @return complaint_name
	 */
	public String getComplaint_name() {
		return complaint_name;
	}
	
	
	/**
	 * sets the complaint_name
	 * @param complaint_name
	 */
	public void setComplaint_name(String complaint_name) {
		this.complaint_name = complaint_name;
	}
	
	/**
	 * gets the particulars
	 * @return particulars
	 */
	public String getParticulars() {
		return particulars;
	}
	
	
	/**
	 * sets the particulars
	 * @param particulars
	 */
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
	
	
	/**
	 * gets the status
	 * @return status
	 */
	public String getStatus() {
		return status;
	}
	
	
	/**
	 * sets the status
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Complaints [complaint_id=" + complaint_id + ", complaint_name=" + complaint_name + ", particulars="
				+ particulars + ", status=" + status + "]";
	}

}
