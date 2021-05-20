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

import com.mph.entity.Complaints;
import com.mph.service.ComplaintsService;

@RestController
public class ComplaintsRestController {
	@Autowired
	ComplaintsService complaintsService;
	
	@GetMapping("/allcomplaints")
	private ResponseEntity<List<Complaints>> allComplaints(){
		List<Complaints> clist=complaintsService.getComplaintsList();
		
		System.out.println("complaints list: "+clist);
		if(clist.isEmpty()) {
			return new ResponseEntity<List<Complaints>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Complaints>>(clist,HttpStatus.OK);
	}
	
	@PostMapping("/createcomplaint")
	private Complaints createEmployee(@RequestBody Complaints complaint){
		
		complaintsService.createComplaint(complaint);
		return complaint;
		
	}
	@DeleteMapping("/deletecomplaint/{txtcid}")
	private ResponseEntity<List<Complaints>> deleteComplaint(@PathVariable("txtcid") int complaint_id){
		
		List<Complaints> list=complaintsService.deleteComplaint(complaint_id);
		System.out.println("complaint list: "+list);
		if(list.isEmpty()) {
			return new ResponseEntity<List<Complaints>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Complaints>>(list,HttpStatus.OK);
	}
	
	@PutMapping("/updatecomplaint")
	private ResponseEntity<List<Complaints>> updateComplaint(@RequestBody Complaints complaint){
		
		List<Complaints> list=complaintsService.updateComplaint(complaint);
		System.out.println("complaint list: "+list);
		if(list.isEmpty()) {
			return new ResponseEntity<List<Complaints>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Complaints>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/searchcomplaint/{id}")
	public ResponseEntity<Complaints> getComplaint(@PathVariable("id") int complaint_id) {
		Complaints complaint=complaintsService.searchComplaint(complaint_id);
		System.out.println("complaint is:" + complaint);
		return new ResponseEntity<Complaints>(complaint, HttpStatus.OK);

	}
}
