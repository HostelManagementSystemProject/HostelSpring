package com.mph.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Booking;

import com.mph.service.BookingService;

@RestController
public class BookingRestController {
	@Autowired
	BookingService bookingService;
	
	
	
	@PostMapping("/createbooking")
	public Booking createBooking(@RequestBody Booking booking)
	{
		bookingService.createBooking(booking);
		return booking;
	}
	
	@GetMapping("/allbookings")
	private ResponseEntity<List<Booking>> allBooking() {
		
		List<Booking> li = bookingService.getBookingList();
		System.out.println("Booking List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Booking>>(li,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deletebooking/{id}")
	private ResponseEntity<List<Booking>> deleteBooking(@PathVariable("id") int booking_id) {
		
		List<Booking> li = bookingService.deleteBooking(booking_id);
		System.out.println("Booking List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Booking>>(li,HttpStatus.OK);
		
	}
	
	@PutMapping("/updatebooking")
	public  ResponseEntity<List<Booking>> updateBooking(@RequestBody Booking booking) {
		System.out.println("from controller"+booking);
		List<Booking> li = bookingService.updateBooking(booking);
		System.out.println("Booking List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Booking>>(li,HttpStatus.OK);
		
	}
	
	@GetMapping("/searchbooking/{id}")
	public ResponseEntity<Booking> getBooking(@PathVariable("id") int booking_id) {
		Booking booking=bookingService.searchBooking(booking_id);
		System.out.println("Booking : " + booking);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);

	}
}
