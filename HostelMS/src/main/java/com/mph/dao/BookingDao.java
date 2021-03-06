package com.mph.dao;

import java.util.List;

import com.mph.entity.Booking;

public interface BookingDao {
	public void createBooking(Booking booking);	
	public Booking getBooking(Booking booking);
	public List<Booking> getBookingList();
	public List<Booking> deleteBooking(int booking_id);
	public List<Booking> updateBooking(Booking booking);
	public Booking searchBooking(int booking_id);
}
