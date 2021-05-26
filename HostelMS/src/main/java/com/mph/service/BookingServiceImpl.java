package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.BookingDao;
import com.mph.entity.Booking;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingDao bookingDao;
	
	/**
	 * This method is used to create booking
	 * @author Priya
	 * @param booking this is the parameter used to create booking
	 */
	@Override
	public void createBooking(Booking booking) {
		bookingDao.createBooking(booking);
		
	}
	
	/**
	 * This method is used to get any single booking based on ID
	 * @author Priya
	 * @param booking this is the parameter used to get a booking
	 * @return returns a specific booking
	 */
	@Override
	public Booking getBooking(Booking booking) {
		return bookingDao.getBooking(booking);
	}

	
	/**
	 * This method is used to get the list of bookings
	 * @author Priya
	 * @param none no parameters are used in this method
	 * @return returns the list of bookings
	 */
	@Override
	public List<Booking> getBookingList() {
		return bookingDao.getBookingList() ;
	}
	
	/**
	 * This method is used to delete the booking based on ID
	 * @author Priya
	 * @param booking_id this is the parameter used to delete the booking
	 * @return returns the list of bookings
	 */
	@Override
	public List<Booking> deleteBooking(int booking_id) {
		return bookingDao.deleteBooking(booking_id) ;
	}
	
	/**
	 * This method is used to update the details of booking
	 * @author Priya
	 * @param booking this is the parameter used to get an booking
	 * @return returns the list of bookings
	 */
	@Override
	public List<Booking> updateBooking(Booking booking) {
		return bookingDao.updateBooking(booking);
		
	}
	
	/**
	 * This method is used to search the booking based on ID
	 * @author Priya
	 * @param booking_id this is the parameter used to search the booking
	 * @return returns a specific booking
	 */
	@Override
	public Booking searchBooking(int booking_id) {
		return bookingDao.searchBooking(booking_id);
	}

}
