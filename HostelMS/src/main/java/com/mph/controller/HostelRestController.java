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


import com.mph.entity.Hostel;
import com.mph.service.HostelService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
@RequestMapping("/hostel")
public class HostelRestController {
	@Autowired
	HostelService hostelService;
	
	
	/**
	 * This method gets the list of hostels
	 * @author Meghana
	 * @return returns the list of hostels
	 */
	@GetMapping("/allhostels")
	private ResponseEntity<List<Hostel>> allHostels(){
		List<Hostel> hlist=hostelService.getHostelList();
		
		System.out.println("hostels list: "+hlist);
		if(hlist.isEmpty()) {
			return new ResponseEntity<List<Hostel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Hostel>>(hlist,HttpStatus.OK);
	}
	
	
	/**
	 * This method creates the hostel
	 * @author Meghana
	 * @param hostel this is the parameter used to create hostel
	 * @return returns hostel
	 */
	@PostMapping("/createhostel")
	private Hostel createHostel(@RequestBody Hostel hostel){
		
		hostelService.createHostel(hostel);
		return hostel;
		
	}
	
	/**
	 * This method delete a specific hostel
	 * @author Meghana
	 * @param hostel_id this is the parameter used to delete hostel
	 * @return returns the list of hostels
	 */
	@DeleteMapping("/deletehostel/{txtcid}")
	private ResponseEntity<List<Hostel>> deleteHostel(@PathVariable("txtcid") int hostel_id){
		
		List<Hostel> list=hostelService.deleteHostel(hostel_id);
		System.out.println("hostel list: "+list);
		if(list.isEmpty()) {
			return new ResponseEntity<List<Hostel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Hostel>>(list,HttpStatus.OK);
	}
	
	
	/**
	 * This method is used to update hostel details
	 * @author Meghana
	 * @param hostel this is the parameter used to update hostel
	 * @return returns the list of hostels
	 */
	@PutMapping("/updatehostel")
	private ResponseEntity<List<Hostel>> updateHostel(@RequestBody Hostel hostel){
		
		List<Hostel> list=hostelService.updateHostel(hostel);
		System.out.println("hostel list: "+list);
		if(list.isEmpty()) {
			return new ResponseEntity<List<Hostel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Hostel>>(list,HttpStatus.OK);
	}
	
	
	/**
	 * This method is used to search hostel details
	 * @author Meghana
	 * @param hostel_id this is the parameter used to search hostel
	 * @return returns hostel
	 */
	@GetMapping("/searchhostel/{id}")
	public ResponseEntity<Hostel> getHostel(@PathVariable("id") int hostel_id) {
		Hostel hostel=hostelService.searchHostel(hostel_id);
		System.out.println("Hostel: " + hostel);
		return new ResponseEntity<Hostel>(hostel, HttpStatus.OK);

	}
}
