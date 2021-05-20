package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.HostelDao;
import com.mph.dao.PaymentDao;
import com.mph.entity.Payment;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentDao paymentDao;

	@Override
	public void createPayment(Payment payment) {
		paymentDao.createPayment(payment);
		
	}

	@Override
	public List<Payment> getPaymentList() {
		return paymentDao.getPaymentList();
	}

	@Override
	public Payment getPayment(Payment payment) {
		return paymentDao.getPayment(payment);
	}

	@Override
	public List<Payment> updatePayment(Payment payment) {
		return paymentDao.updatePayment(payment);
	}

	@Override
	public List<Payment> deletePayment(int payment_id) {
		return paymentDao.deletePayment(payment_id);
	}

}
