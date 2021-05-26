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

import com.mph.entity.Admin;
import com.mph.entity.Payment;
import com.mph.service.HostelService;
import com.mph.service.PaymentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
@RequestMapping("/payment")
public class PaymentRestController {
	@Autowired
	PaymentService paymentService;
	
	
	/**
	 * This method gets the list of payments
	 * @author Meghana
	 * @return returns the list of payments
	 */
	@GetMapping("/allpayments")
	private ResponseEntity<List<Payment>> allPayments(){
		List<Payment> plist=paymentService.getPaymentList();
		
		System.out.println("payment list: "+plist);
		if(plist.isEmpty()) {
			return new ResponseEntity<List<Payment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Payment>>(plist,HttpStatus.OK);
	}
	
	
	/**
	 * This method creates the payment
	 * @author Meghana
	 * @param payment this is the parameter used to create payment
	 * @return returns payment
	 */
	@PostMapping("/createpayment")
	private Payment createPayment(@RequestBody Payment payment){
		
		paymentService.createPayment(payment);
		return payment;
		
	}
	
	/**
	 * This method delete a specific payment
	 * @author Meghana
	 * @param payment_id this is the parameter used to delete payment
	 * @return returns the list of payments
	 */
	@DeleteMapping("/deletepayment/{txtcid}")
	private ResponseEntity<List<Payment>> deletePayment(@PathVariable("txtcid") int payment_id){
		
		List<Payment> list=paymentService.deletePayment(payment_id);
		System.out.println("payment list: "+list);
		if(list.isEmpty()) {
			return new ResponseEntity<List<Payment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Payment>>(list,HttpStatus.OK);
	}
	
	
	/**
	 * This method is used to update payment details
	 * @author Meghana
	 * @param payment this is the parameter used to update payment
	 * @return returns the list of payments
	 */
	@PutMapping("/updatepayment")
	private ResponseEntity<List<Payment>> updatePayment(@RequestBody Payment payment){
		
		List<Payment> list=paymentService.updatePayment(payment);
		System.out.println("payment list: "+list);
		if(list.isEmpty()) {
			return new ResponseEntity<List<Payment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Payment>>(list,HttpStatus.OK);
	}
	
	
	/**
	 * This method is used to search payment details
	 * @author Meghana
	 * @param payment_id this is the parameter used to search payment
	 * @return returns payment
	 */
	@GetMapping("/searchpayment/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable("id") int payment_id) {
		Payment payment=paymentService.searchPayment(payment_id);
		System.out.println("Payment: " + payment);
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);

	}
}
