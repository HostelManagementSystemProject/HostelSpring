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

import com.mph.entity.Admin;
import com.mph.entity.Payment;
import com.mph.service.HostelService;
import com.mph.service.PaymentService;

@RestController
public class PaymentRestController {
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/allpayments")
	private ResponseEntity<List<Payment>> allPayments(){
		List<Payment> plist=paymentService.getPaymentList();
		
		System.out.println("payment list: "+plist);
		if(plist.isEmpty()) {
			return new ResponseEntity<List<Payment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Payment>>(plist,HttpStatus.OK);
	}
	
	@PostMapping("/createpayment")
	private Payment createPayment(@RequestBody Payment payment){
		
		paymentService.createPayment(payment);
		return payment;
		
	}
	@DeleteMapping("/deletepayment/{txtcid}")
	private ResponseEntity<List<Payment>> deletePayment(@PathVariable("txtcid") int payment_id){
		
		List<Payment> list=paymentService.deletePayment(payment_id);
		System.out.println("payment list: "+list);
		if(list.isEmpty()) {
			return new ResponseEntity<List<Payment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Payment>>(list,HttpStatus.OK);
	}
	
	@PutMapping("/updatepayment")
	private ResponseEntity<List<Payment>> updatePayment(@RequestBody Payment payment){
		
		List<Payment> list=paymentService.updatePayment(payment);
		System.out.println("payment list: "+list);
		if(list.isEmpty()) {
			return new ResponseEntity<List<Payment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Payment>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/searchpayment/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable("id") int payment_id) {
		Payment payment=paymentService.searchPayment(payment_id);
		System.out.println("Payment: " + payment);
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);

	}
}
