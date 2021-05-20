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
	@Override
	public void createBooking(Booking booking) {
		bookingDao.createBooking(booking);
		
	}
	
	@Override
	public Booking getBooking(Booking booking) {
		return bookingDao.getBooking(booking);
	}

	

	@Override
	public List<Booking> getBookingList() {
		return bookingDao.getBookingList() ;
	}

	@Override
	public List<Booking> deleteBooking(int booking_id) {
		return bookingDao.deleteBooking(booking_id) ;
	}

	@Override
	public List<Booking> updateBooking(Booking booking) {
		return bookingDao.updateBooking(booking);
		
	}

}
