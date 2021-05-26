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

import com.mph.entity.Staff;
import com.mph.entity.User;
import com.mph.service.StaffService;
import com.mph.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
@RequestMapping("/staff")
public class StaffRestController {
	@Autowired
	StaffService staffService;
	
	
	/**
	 * This method gets the list of staff
	 * @author Priya
	 * @return returns the list of staff
	 */
	@GetMapping("/allstaff")
	public ResponseEntity<List<Staff>> allStaff() {
		
		List<Staff> li = staffService.getStaffList();
		System.out.println("Staff List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Staff>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Staff>>(li,HttpStatus.OK);
		
	}
	
	
	/**
	 * This method creates the staff
	 * @author Priya
	 * @param staff this is the parameter used to create staff
	 * @return returns staff
	 */
	@PostMapping("/createstaff")
	public Staff createStaff(@RequestBody Staff staff)
	{
		staffService.createStaff(staff);
		return staff;
	}
	
	
	/**
	 * This method delete a specific staff member
	 * @author Priya
	 * @param emid this is the parameter used to delete staff
	 * @return returns the list of staff
	 */
	@DeleteMapping("/deletestaff/{id}")
	public  ResponseEntity<List<Staff>> deleteStaff(@PathVariable("id") int emid) {
		
		List<Staff> li = staffService.deleteStaff(emid);
		System.out.println("Staff List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Staff>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Staff>>(li,HttpStatus.OK);
		
	}
	
	
	/**
	 * This method is used to update staff details
	 * @author Priya
	 * @param staff this is the parameter used to update staff
	 * @return returns the list of staff
	 */
	@PutMapping("/updatestaff")
	public  ResponseEntity<List<Staff>> updateStaff(@RequestBody Staff staff) {
		System.out.println("From controller ..." + staff);
		List<Staff> li = staffService.updateStaff(staff);
		System.out.println("Staff List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Staff>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Staff>>(li,HttpStatus.OK);
		
	}
	
	
	/**
	 * This method is used to search staff details
	 * @author Priya
	 * @param staff_id this is the parameter used to search staff
	 * @return returns staff
	 */
	@GetMapping("/searchstaff/{id}")
	public ResponseEntity<Staff> getStaff(@PathVariable("id") int staff_id) {
		Staff staff=staffService.searchStaff(staff_id);
		System.out.println("Staff : " + staff);
		return new ResponseEntity<Staff>(staff, HttpStatus.OK);

	}
	
	
	/**
	 * This method is used to get staff details
	 * @author Priya
	 * @param staff_id this is the parameter used to get staff
	 * @return returns staff
	 */
	@GetMapping("/getstaffbyid/{id}")
	public ResponseEntity<Staff> getStaffById(@PathVariable("id") int staff_id) {
		Staff staff=staffService.getStaffById(staff_id);
		System.out.println("Staff : " + staff);
		return new ResponseEntity<Staff>(staff, HttpStatus.OK);

	}
}
