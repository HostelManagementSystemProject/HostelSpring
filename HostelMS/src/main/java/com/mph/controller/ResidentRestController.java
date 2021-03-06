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

import com.mph.entity.Resident;
import com.mph.entity.Staff;
import com.mph.entity.User;
import com.mph.service.ResidentService;


@RestController
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
@RequestMapping("/resident")
public class ResidentRestController {
	@Autowired
	ResidentService residentService;
	
	
	/**
	 * This method creates the resident
	 * @author Chandrika
	 * @param resident this is the parameter used to create resident
	 * @return returns resident
	 */
	@PostMapping("/createresident")
	public Resident createResident(@RequestBody Resident resident) {
		residentService.createResident(resident);
		return resident;
	}
	
	
	/**
	 * This method gets the list of residents
	 * @author Chandrika
	 * @return returns the list of residents
	 */
	@GetMapping("/allresidents")
	public ResponseEntity<List<Resident>> allResident() {

		List<Resident> li = residentService.getResidentList();
		System.out.println("Resident List : " + li);

		if (li.isEmpty()) {
			return new ResponseEntity<List<Resident>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Resident>>(li, HttpStatus.OK);
	}
	
	
	/**
	 * This method delete a specific resident
	 * @author Chandrika
	 * @param resident_id this is the parameter used to delete resident
	 * @return returns the list of residents
	 */
	@DeleteMapping("/deleteresident/{id}")
	public ResponseEntity<List<Resident>> deleteResident(@PathVariable("id") int rid) {

		List<Resident> li = residentService.deleteResident(rid);
		System.out.println("Resident List : " + li);

		if (li.isEmpty()) {
			return new ResponseEntity<List<Resident>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Resident>>(li, HttpStatus.OK);

	}
	
	
	/**
	 * This method is used to update resident details
	 * @author Chandrika
	 * @param resident this is the parameter used to update resident
	 * @return returns the list of residents
	 */
	@PutMapping("/updateresident")
	public  ResponseEntity<List<Resident>> updateResident(@RequestBody Resident resident) {
		System.out.println("From controller ..." + resident);
		List<Resident> li = residentService.updateResident(resident);
		System.out.println("Resident List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Resident>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Resident>>(li,HttpStatus.OK);
		
	}
	
	
	/**
	 * This method is used to search resident details
	 * @author Chandrika
	 * @param resident_id this is the parameter used to search resident
	 * @return returns resident
	 */
	@GetMapping("/searchresident/{id}")
	public ResponseEntity<Resident> getResident(@PathVariable("id") int rid) {
		Resident resident = residentService.searchResident(rid);
		System.out.println("resident : " + resident);
		return new ResponseEntity<Resident>(resident, HttpStatus.OK);

	}
	
	
	/**
	 * This method is used to get resident details by ID
	 * @author Chandrika
	 * @param resident_id this is the parameter used to get resident
	 * @return returns resident
	 */
	@GetMapping("/getresidentbyid/{id}")
	public ResponseEntity<Resident> getResidentById(@PathVariable("id") int rid) {
		Resident resident = residentService.getResidentById(rid);
		System.out.println("resident : " + resident);
		return new ResponseEntity<Resident>(resident, HttpStatus.OK);

	}
	
	
	@GetMapping("/residentdetails/{email}/{password}")
	public ResponseEntity<Resident> getResident(@PathVariable("email") String email_id,@PathVariable("password") String password) {
		Resident r = residentService.getResidentEmail(email_id,password);
		System.out.println("Resident : " + r);
		return new ResponseEntity<Resident>(r, HttpStatus.OK);

	}
}
