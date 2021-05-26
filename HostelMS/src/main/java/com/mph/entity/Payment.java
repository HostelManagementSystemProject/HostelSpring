package com.mph.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity(name = "PAYMENT_HMS")
@IdClass(CompositePayment.class)
public class Payment {

	@Id
	@SequenceGenerator(name = "paymentseq", sequenceName = "paymentseq", initialValue = 50, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentseq")
	private int payment_id;

	@NotNull
	private Date due_date;

	@NotNull
	private Date date_of_payment;
	
	@Id
	@SequenceGenerator(name = "receiptseq", sequenceName = "receiptseq", initialValue = 50, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receiptseq")
	private int receipt_no;
	
	private float amount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id", referencedColumnName = "BOOKING_ID")
	private Booking booking;
	
	@OneToOne
	@JoinColumn(name = "user_name", referencedColumnName = "USER_NAME")
	private User user;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int payment_id, Date due_date, Date date_of_payment, int receipt_no, float amount, Booking booking,
			User user) {
		super();
		this.payment_id = payment_id;
		this.due_date = due_date;
		this.date_of_payment = date_of_payment;
		this.receipt_no = receipt_no;
		this.amount = amount;
		this.booking = booking;
		this.user = user;
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

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", due_date=" + due_date + ", date_of_payment=" + date_of_payment
				+ ", receipt_no=" + receipt_no + ", amount=" + amount + ", booking=" + booking + ", user=" + user + "]";
	}

	

	
}
