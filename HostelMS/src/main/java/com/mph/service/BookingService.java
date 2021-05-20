package com.mph.service;

import java.util.List;

import com.mph.entity.Booking;

public interface BookingService {
	public void createBooking(Booking booking);	
	public Booking getBooking(Booking booking);
	public List<Booking> getBookingList();
	public List<Booking> deleteBooking(int booking_id);
	public List<Booking> updateBooking(Booking booking);
}
