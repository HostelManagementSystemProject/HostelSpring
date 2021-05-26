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
	
	
	/**
	 * This method is used to add payment
	 * @author Meghana
	 * @param payment this is the parameter used to create payment
	 */
	@Override
	public void createPayment(Payment payment) {
		paymentDao.createPayment(payment);
		
	}
	
	
	/**
	 * This method is used to get the list ofpayments
	 * @author Meghana
	 * @param none no parameters are used in this method
	 * @return returns the list of payments
	 */
	@Override
	public List<Payment> getPaymentList() {
		return paymentDao.getPaymentList();
	}
	
	
	/**
	 * This method is used to get any single payment based on ID
	 * @author Meghana
	 * @param payment this is the parameter used to get a payment
	 * @return returns a specific payment
	 */
	@Override
	public Payment getPayment(Payment payment) {
		return paymentDao.getPayment(payment);
	}
	
	
	/**
	 * This method is used to update the details of payment
	 * @author Meghana
	 * @param payment this is the parameter used to get a payment
	 * @return returns the list of payments
	 */
	@Override
	public List<Payment> updatePayment(Payment payment) {
		return paymentDao.updatePayment(payment);
	}
	
	
	/**
	 * This method is used to delete the payment based on ID
	 * @author Meghana
	 * @param payment_id this is the parameter used to delete the payment
	 * @return returns the list of payments
	 */
	@Override
	public List<Payment> deletePayment(int payment_id) {
		return paymentDao.deletePayment(payment_id);
	}
	
	
	/**
	 * This method is used to search the payment based on ID
	 * @author Meghana
	 * @param payment_id this is the parameter used to search the payment
	 * @return returns a specific payment
	 */
	@Override
	public Payment searchPayment(int payment_id) {
		return paymentDao.searchPayment(payment_id);
	}

}
