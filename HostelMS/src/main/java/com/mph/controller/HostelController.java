package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mph.entity.Hostel;
import com.mph.service.HostelService;

@Controller
public class HostelController {
	
	Hostel hostel;
	
	@Autowired
	HostelService hostelService;
	
	@RequestMapping(value = "/addhostel", method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("addhostel");

	}
	
	@RequestMapping(value="/addhostel" ,method=RequestMethod.POST)
	public ModelAndView create(@RequestParam ("txthid") int hostel_id,
			@RequestParam("txthname") String hostel_name ,
			@RequestParam("txtaddress") String hostel_address,
			@RequestParam("txtphone") long phone_number)
	{
		//System.out.println();
		hostel=new Hostel();
		hostel.setHostel_id(hostel_id);
		hostel.setHostel_name(hostel_name);
		hostel.setHostel_address(hostel_address);
		hostel.setPhone_number(phone_number);
		
		hostelService.createHostel(hostel);
		
		return new ModelAndView("listhostel");
		
	}
	
	public ModelAndView allHostel() {
		List<Hostel> li=hostelService.getHostelList();
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("hostellist",li);
		return mv;
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView signup(@RequestParam ("txthid") int hostel_id)
	{
		hostel=new Hostel();
		hostel.setHostel_id(hostel_id);
		
		Hostel hs=hostelService.getHostel(hostel);
		if(hs==null)
		{
			ModelAndView mv=new ModelAndView("listhostel");
			mv.addObject("msg", "Hostel not found!!!");
			return mv;
		}
		else {
			return allHostel();
		}
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(Hostel hostel) 
	{
		List<Hostel> hostellist=hostelService.deleteHostel(hostel.getHostel_id());
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("hostellist", hostellist);
		return mv;
		
	}
	
	@RequestMapping(value = "/edithostel", method = RequestMethod.GET)
	public ModelAndView edit(Hostel hostel) 
	{
		return new ModelAndView("edithostel");
		
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute Hostel hostel) 
	{
		hostelService.updateHostel(hostel);
		return allHostel();
		
	}
}
