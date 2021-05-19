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
	
	@Override
	public void createPayment(Payment payment) {
		getSession().saveOrUpdate(payment);
		System.out.println("Data Stored in DB Successfully...!!!");
		
	}

	@Override
	public List<Payment> getPaymentList() {
		Query query = getSession().createQuery("select payments from PAYMENT_HMS payments");
		List<Payment> paymentlist=query.list();
		return paymentlist;
	}

	@Override
	public Payment getPayment(Payment payment) {
		Criteria c=getSession().createCriteria(Payment.class);
		c.add(Restrictions.eq("payment_id",payment.getPayment_id()));
		Payment payments=(Payment) c.uniqueResult();
		return payments;
	}

	@Override
	public List<Payment> updatePayment(Payment payment) {
		Query query = getSession().createQuery("update PAYMENT_HMS payment set due_date=:due_date,date_of_payment=:date_of_payment,receipt_no=:receipt_no where payment_id=:payment_id");
		query.setParameter("payment_id",payment.getPayment_id());
		query.setParameter("due_date",payment.getDue_date());
		query.setParameter("date_of_payment",payment.getDate_of_payment());
		query.setParameter("receipt_no",payment.getReceipt_no());
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Updated successfully");
		}
		
		return getPaymentList();
	}

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

}
