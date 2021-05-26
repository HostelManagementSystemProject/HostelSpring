package com.mph.entity;

import java.io.Serializable;

public class CompositePayment implements Serializable{
	private int payment_id;
	private int receipt_no;
	public CompositePayment() {
	}
	public CompositePayment(int payment_id, int receipt_no) {
		this.payment_id = payment_id;
		this.receipt_no = receipt_no;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + payment_id;
		result = prime * result + receipt_no;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositePayment other = (CompositePayment) obj;
		if (payment_id != other.payment_id)
			return false;
		if (receipt_no != other.receipt_no)
			return false;
		return true;
	}

	
}
