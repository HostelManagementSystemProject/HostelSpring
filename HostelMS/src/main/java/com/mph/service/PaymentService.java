package com.mph.service;

import java.util.List;

import com.mph.entity.Payment;

public interface PaymentService {
	public void createPayment(Payment payment);
	public List<Payment> getPaymentList();
	public Payment getPayment(Payment payment);
	public List<Payment> updatePayment(Payment payment);
	public List<Payment> deletePayment(int payment_id);
	public Payment searchPayment(int payment_id);
}
