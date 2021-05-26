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
import com.mph.service.ResidentService;


@RestController
@RequestMapping("/resident")
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}, allowedHeaders = "*")
public class ResidentRestController {
	@Autowired
	ResidentService residentService;

	@PostMapping("/createresident")
	public Resident createResident(@RequestBody Resident resident) {
		residentService.createResident(resident);
		return resident;
	}

	@GetMapping("/allresidents")
	public ResponseEntity<List<Resident>> allResident() {

		List<Resident> li = residentService.getResidentList();
		System.out.println("Resident List : " + li);

		if (li.isEmpty()) {
			return new ResponseEntity<List<Resident>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Resident>>(li, HttpStatus.OK);
	}

	@DeleteMapping("/deleteresident/{id}")
	public ResponseEntity<List<Resident>> deleteResident(@PathVariable("id") int rid) {

		List<Resident> li = residentService.deleteResident(rid);
		System.out.println("Resident List : " + li);

		if (li.isEmpty()) {
			return new ResponseEntity<List<Resident>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Resident>>(li, HttpStatus.OK);

	}

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

	@GetMapping("/searchresident/{id}")
	public ResponseEntity<Resident> getResident(@PathVariable("id") int rid) {
		Resident resident = residentService.searchResident(rid);
		System.out.println("resident : " + resident);
		return new ResponseEntity<Resident>(resident, HttpStatus.OK);

	}
	
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
