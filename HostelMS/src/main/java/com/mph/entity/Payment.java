package com.mph.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="PAYMENT_HMS")
public class Payment {
	@Id
	private int payment_id;
	
	private Date due_date;
	//@DateTimeFormat(pattern = "ddMMyyHHmmss")
	private Date date_of_payment;
	private int receipt_no;
	@OneToOne(cascade=CascadeType.ALL)
	private Booking booking_id;
	//@OneToOne(cascade=CascadeType.ALL)
	//private User user_id;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int payment_id, Date due_date, Date date_of_payment, int receipt_no, Booking booking_id) 
	{
		super();
		this.payment_id = payment_id;
		this.due_date = due_date;
		this.date_of_payment = date_of_payment;
		this.receipt_no = receipt_no;
		this.booking_id = booking_id;
		
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getDate_of_payment() {
		return date_of_payment;
	}
	public void setDate_of_payment(Date date_of_payment) {
		this.date_of_payment = date_of_payment;
	}
	public int getReceipt_no() {
		return receipt_no;
	}
	public void setReceipt_no(int receipt_no) {
		this.receipt_no = receipt_no;
	}
	public Booking getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(Booking booking_id) {
		this.booking_id = booking_id;
	}
	/*public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}*/
	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", due_date=" + due_date + ", date_of_payment=" + date_of_payment
				+ ", receipt_no=" + receipt_no + ", booking_id=" + booking_id + "]";
	}
	
}
