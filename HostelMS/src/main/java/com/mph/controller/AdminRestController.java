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
import com.mph.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "false", methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*")
@RequestMapping("/admin")
public class AdminRestController {
	@Autowired
	AdminService adminService;

	/**
	 * This method gets the list of admins
	 * 
	 * @author Kushdeep
	 * @return returns the list of admins
	 */
	@GetMapping("/alladmins")
	private ResponseEntity<List<Admin>> allAdmins() {
		List<Admin> alist = adminService.getAdminList();

		System.out.println("complaints list: " + alist);
		if (alist.isEmpty()) {
			return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Admin>>(alist, HttpStatus.OK);
	}

	/**
	 * This method creates the admin
	 * 
	 * @author Kushdeep
	 * @param admin this is the parameter used to create admin
	 * @return returns admin
	 */
	@PostMapping("/createadmin")
	private Admin createAdmin(@RequestBody Admin admin) {

		adminService.createAdmin(admin);
		return admin;

	}

	/**
	 * This method delete a specific admin
	 * 
	 * @author Kushdeep
	 * @param admin_id this is the parameter used to delete admin
	 * @return returns the list of admins
	 */
	@DeleteMapping("/deleteadmin/{txtcid}")
	private ResponseEntity<List<Admin>> deleteComplaint(@PathVariable("txtcid") int admin_id) {

		List<Admin> list = adminService.deleteAdmin(admin_id);
		System.out.println("admin list: " + list);
		if (list.isEmpty()) {
			return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Admin>>(list, HttpStatus.OK);
	}

	/**
	 * This method is used to update admin details
	 * 
	 * @author Kushdeep
	 * @param admin this is the parameter used to update admin
	 * @return returns the list of admins
	 */
	@PutMapping("/updateadmin")
	private ResponseEntity<List<Admin>> updateAdmin(@RequestBody Admin admin) {

		List<Admin> list = adminService.updateAdmin(admin);
		System.out.println("admin list: " + list);
		if (list.isEmpty()) {
			return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Admin>>(list, HttpStatus.OK);
	}

	/**
	 * This method is used to search admin details
	 * 
	 * @author Kushdeep
	 * @param admin_id this is the parameter used to serach admin
	 * @return returns admin
	 */
	@GetMapping("/searchadmin/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("id") int admin_id) {
		Admin admin = adminService.searchAdmin(admin_id);
		System.out.println("admin : " + admin);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);

	}
}
