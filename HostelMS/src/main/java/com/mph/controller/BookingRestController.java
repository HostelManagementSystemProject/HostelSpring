package com.mph.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Booking;

import com.mph.service.BookingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
@RequestMapping("/booking")
public class BookingRestController {
	@Autowired
	BookingService bookingService;
	
	
	/**
	 * This method creates the booking
	 * @author Priya
	 * @param booking this is the parameter used to create booking
	 * @return returns booking
	 */
	@PostMapping("/createbooking")
	public Booking createBooking(@RequestBody Booking booking)
	{
		bookingService.createBooking(booking);
		return booking;
	}
	
	
	/**
	 * This method gets the list of bookings
	 * @author Priya
	 * @return returns the list of bookings
	 */
	@GetMapping("/allbookings")
	private ResponseEntity<List<Booking>> allBooking() {
		//System.out.println("from rest...");
		List<Booking> li = bookingService.getBookingList();
		System.out.println("Booking List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Booking>>(li,HttpStatus.OK);
		
	}
	
	
	/**
	 * This method delete a specific booking
	 * @author Priya
	 * @param booking_id this is the parameter used to delete booking
	 * @return returns the list of bookings
	 */
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
	
	
	/**
	 * This method is used to update booking details
	 * @author Priya
	 * @param booking this is the parameter used to update booking
	 * @return returns the list of bookings
	 */
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
	
	
	/**
	 * This method is used to search booking details
	 * @author Priya
	 * @param booking_id this is the parameter used to search booking
	 * @return returns booking
	 */
	@GetMapping("/searchbooking/{id}")
	public ResponseEntity<Booking> getBooking(@PathVariable("id") int booking_id) {
		Booking booking=bookingService.searchBooking(booking_id);
		System.out.println("Booking : " + booking);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);

	}
}
