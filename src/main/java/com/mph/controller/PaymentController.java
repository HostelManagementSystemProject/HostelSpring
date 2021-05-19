package com.mph.controller;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mph.entity.Hostel;
import com.mph.entity.Payment;
import com.mph.service.PaymentService;

@Controller
public class PaymentController {
	
	Payment payment;
	
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping(value = "/addpayment", method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("addpayment");

	}
	
	@RequestMapping(value="/addpayment" ,method=RequestMethod.POST)
	public ModelAndView create(@RequestParam ("txtpid") int payment_id,
			@RequestParam("txtdue")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date due_date,
			@RequestParam("txtdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date_of_payment,
			@RequestParam("txtrno") int receipt_no)
	{
		//System.out.println();
		payment=new Payment();
		payment.setPayment_id(payment_id);
		payment.setDue_date(due_date);
		payment.setDate_of_payment(date_of_payment);
		payment.setReceipt_no(receipt_no);
		
		paymentService.createPayment(payment);
		
		return new ModelAndView("listpayment");
		
	}
	
	public ModelAndView allPayment() {
		List<Payment> li=paymentService.getPaymentList();
		ModelAndView mv=new ModelAndView("homepayment");
		mv.addObject("paymentlist",li);
		return mv;
	}
	
	@RequestMapping(value="/signuppayment",method=RequestMethod.GET)
	public ModelAndView signuppayment(@RequestParam ("txtpid") int payment_id)
	{
		payment=new Payment();
		payment.setPayment_id(payment_id);
		
		Payment ps=paymentService.getPayment(payment);
		if(ps==null)
		{
			ModelAndView mv=new ModelAndView("listpayment");
			mv.addObject("msg", "Payment not found!!!");
			return mv;
		}
		else {
			return allPayment();
		}
		
	}
	
	@RequestMapping(value = "/deletepayment", method = RequestMethod.GET)
	public ModelAndView delete(Payment payment) 
	{
		List<Payment> paymentlist=paymentService.deletePayment(payment.getPayment_id());
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("paymentlist", paymentlist);
		return mv;
		
	}
	
	@RequestMapping(value = "/editpayment", method = RequestMethod.GET)
	public ModelAndView edit(Payment payment) 
	{
		return new ModelAndView("editpayment");
		
	}
	@RequestMapping(value = "/updatepayment", method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute Payment payment) 
	{
		paymentService.updatePayment(payment);
		return allPayment();
		
	}
}
