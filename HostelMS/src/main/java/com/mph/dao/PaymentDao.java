package com.mph.dao;

import java.util.List;

import com.mph.entity.Payment;

public interface PaymentDao {
	public void createPayment(Payment payment);
	public List<Payment> getPaymentList();
	public Payment getPayment(Payment payment);
	public List<Payment> updatePayment(Payment payment);
	public List<Payment> deletePayment(int payment_id);
}
