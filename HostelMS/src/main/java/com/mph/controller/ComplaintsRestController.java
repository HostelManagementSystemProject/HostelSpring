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

import com.mph.entity.Complaints;
import com.mph.service.ComplaintsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
@RequestMapping("/complaints")
public class ComplaintsRestController {
	@Autowired
	ComplaintsService complaintsService;
	
	
	/**
	 * This method gets the list of complaints
	 * @author Bhavana
	 * @return returns the list of complaints
	 */
	@GetMapping("/allcomplaints")
	private ResponseEntity<List<Complaints>> allComplaints(){
		List<Complaints> clist=complaintsService.getComplaintsList();
		
		System.out.println("complaints list: "+clist);
		if(clist.isEmpty()) {
			return new ResponseEntity<List<Complaints>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Complaints>>(clist,HttpStatus.OK);
	}
	
	
	/**
	 * This method creates the complaint
	 * @author Bhavana
	 * @param complaint this is the parameter used to create complaint
	 * @return returns complaint
	 */
	@PostMapping("/createcomplaint")
	private Complaints createEmployee(@RequestBody Complaints complaint){
		
		complaintsService.createComplaint(complaint);
		return complaint;
		
	}
	
	/**
	 * This method delete a specific complaint
	 * @author Bhavana
	 * @param complaint_id this is the parameter used to delete complaint
	 * @return returns the list of complaints
	 */
	@DeleteMapping("/deletecomplaint/{txtcid}")
	private ResponseEntity<List<Complaints>> deleteComplaint(@PathVariable("txtcid") int complaint_id){
		
		List<Complaints> list=complaintsService.deleteComplaint(complaint_id);
		System.out.println("complaint list: "+list);
		if(list.isEmpty()) {
			return new ResponseEntity<List<Complaints>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Complaints>>(list,HttpStatus.OK);
	}
	
	
	/**
	 * This method is used to update complaint details
	 * @author Bhavana
	 * @param complaint this is the parameter used to update complaint
	 * @return returns the list of complaints
	 */
	@PutMapping("/updatecomplaint")
	private ResponseEntity<List<Complaints>> updateComplaint(@RequestBody Complaints complaint){
		
		List<Complaints> list=complaintsService.updateComplaint(complaint);
		System.out.println("complaint list: "+list);
		if(list.isEmpty()) {
			return new ResponseEntity<List<Complaints>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Complaints>>(list,HttpStatus.OK);
	}
	
	
	/**
	 * This method is used to search complaint details
	 * @author Bhavana
	 * @param complaint_id this is the parameter used to search complaint
	 * @return returns complaint
	 */
	@GetMapping("/searchcomplaint/{id}")
	public ResponseEntity<Complaints> getComplaint(@PathVariable("id") int complaint_id) {
		Complaints complaint=complaintsService.searchComplaint(complaint_id);
		System.out.println("complaint is:" + complaint);
		return new ResponseEntity<Complaints>(complaint, HttpStatus.OK);

	}
	
	
	/**
	 * This method is used to get complaint details by Id
	 * @author Bhavana
	 * @param complaint_id this is the parameter used to get complaint
	 * @return returns complaint
	 */
	@GetMapping("/getcomplaintbyid/{id}")
	public ResponseEntity<Complaints> getComplaintById(@PathVariable("id") int complaint_id) {
		Complaints complaint=complaintsService.getComplaintById(complaint_id);
		System.out.println("complaint is:" + complaint);
		return new ResponseEntity<Complaints>(complaint, HttpStatus.OK);

	}
}
