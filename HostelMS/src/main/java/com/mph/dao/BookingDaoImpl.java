package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Booking;

@Repository
public class BookingDaoImpl implements BookingDao{

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * This method is used to create booking
	 * @author Priya
	 * @param booking this is the parameter used to create booking
	 */
	@Override
	public void createBooking(Booking booking) {
		getSession().saveOrUpdate(booking);
		System.out.println("Booking Done!!");
		System.out.println(booking);
		
	}
	
	/**
	 * This method is used to get the list of bookings
	 * @author Priya
	 * @param none no parameters are used in this method
	 * @return returns the list of bookings
	 */
	@Override
	public List<Booking> getBookingList() {
		Query query = getSession().createQuery("select bookings from BOOKING_HMS bookings");
		List<Booking> bookinglist=query.list();
        return bookinglist;
		
	}
	
	/**
	 * This method is used to delete the booking based on ID
	 * @author Priya
	 * @param booking_id this is the parameter used to delete the booking
	 * @return returns the list of bookings
	 */
	@Override
	public List<Booking> deleteBooking(int booking_id) {
		Query query = getSession().createQuery("delete from BOOKING_HMS where booking_id =:booking_id");
		query.setParameter("booking_id", booking_id);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		return getBookingList();
	}
	
	/**
	 * This method is used to get any single booking based on ID
	 * @author Priya
	 * @param booking this is the parameter used to get a booking
	 * @return returns a specific booking
	 */
	@Override
	public Booking getBooking(Booking booking) {
		Criteria c = getSession().createCriteria(Booking.class);
		c.add(Restrictions.eq("booking_id", booking.getBooking_id()));
		return (Booking) c.uniqueResult();
	}
	
	/**
	 * This method is used to update the details of booking
	 * @author Priya
	 * @param booking this is the parameter used to get an booking
	 * @return returns the list of bookings
	 */
	@Override
	public List<Booking> updateBooking(Booking booking) {
		System.out.println("updating value"+booking);
		Query query = getSession().createQuery("update BOOKING_HMS set booking_date=:booking_date,check_in=:check_in,check_out=:check_out,user_name=:user_name where booking_id=:booking_id");
		query.setParameter("booking_id",booking.getBooking_id());
		query.setParameter("booking_date",booking.getBooking_date());
		query.setParameter("check_in",booking.getCheck_in());
		query.setParameter("check_out",booking.getCheck_out());
		query.setParameter("user_name",booking.getUser());
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Updated successfully");
		}
		//getSession().update(booking);
		
		
		return getBookingList();
		
	}
	
	/**
	 * This method is used to search the booking based on ID
	 * @author Priya
	 * @param booking_id this is the parameter used to search the booking
	 * @return returns a specific booking
	 */
	@Override
	public Booking searchBooking(int booking_id) {
		Criteria c=getSession().createCriteria(Booking.class);
		c.add(Restrictions.eq("booking_id",booking_id));
		Booking booking=(Booking) c.uniqueResult();
		return booking;
	}
}
