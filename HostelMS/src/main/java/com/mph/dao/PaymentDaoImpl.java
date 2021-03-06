package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Hostel;
import com.mph.entity.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * This method is used to add payment
	 * @author Meghana
	 * @param payment this is the parameter used to create payment
	 */
	@Override
	public void createPayment(Payment payment) {
		getSession().saveOrUpdate(payment);
		System.out.println("Data Stored in DB Successfully...!!!");
		
	}
	
	/**
	 * This method is used to get the list ofpayments
	 * @author Meghana
	 * @param none no parameters are used in this method
	 * @return returns the list of payments
	 */
	@Override
	public List<Payment> getPaymentList() {
		Query query = getSession().createQuery("select payments from PAYMENT_HMS payments");
		List<Payment> paymentlist=query.list();
		return paymentlist;
	}
	
	/**
	 * This method is used to get any single payment based on ID
	 * @author Meghana
	 * @param payment this is the parameter used to get a payment
	 * @return returns a specific payment
	 */
	@Override
	public Payment getPayment(Payment payment) {
		Criteria c=getSession().createCriteria(Payment.class);
		c.add(Restrictions.eq("payment_id",payment.getPayment_id()));
		Payment payments=(Payment) c.uniqueResult();
		return payments;
	}
	
	/**
	 * This method is used to update the details of payment
	 * @author Meghana
	 * @param payment this is the parameter used to get a payment
	 * @return returns the list of payments
	 */
	@Override
	public List<Payment> updatePayment(Payment payment) {
		System.out.println("from dao");
		Query query = getSession().createQuery("update PAYMENT_HMS set due_date=:due_date,date_of_payment=:date_of_payment,receipt_no=:receipt_no,amount=:amount where payment_id=:payment_id");
		query.setParameter("payment_id",payment.getPayment_id());
		query.setParameter("due_date",payment.getDue_date());
		query.setParameter("date_of_payment",payment.getDate_of_payment());
		query.setParameter("receipt_no",payment.getReceipt_no());
		query.setParameter("amount",payment.getAmount());
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Updated successfully");
		}
		
		return getPaymentList();
	}
	
	/**
	 * This method is used to delete the payment based on ID
	 * @author Meghana
	 * @param payment_id this is the parameter used to delete the payment
	 * @return returns the list of payments
	 */
	@Override
	public List<Payment> deletePayment(int payment_id) {
		Query query = getSession().createQuery("delete PAYMENT_HMS payment where payment_id=:payment_id");
		query.setParameter("payment_id",payment_id);
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Deleted successfully");
		}
		
		return getPaymentList();
	}
	
	/**
	 * This method is used to search the payment based on ID
	 * @author Meghana
	 * @param payment_id this is the parameter used to search the payment
	 * @return returns a specific payment
	 */
	@Override
	public Payment searchPayment(int payment_id) {
		Criteria c=getSession().createCriteria(Payment.class);
		c.add(Restrictions.eq("payment_id",payment_id));
		Payment payment=(Payment) c.uniqueResult();
		return payment;
	}

}
