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

import com.mph.entity.User;
import com.mph.service.UserService;


@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/alluser")
	public ResponseEntity<List<User>> allUser() {
		
		List<User> li = userService.getUserList();
		System.out.println("User List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(li,HttpStatus.OK);
		
	}
	
	@PostMapping("/createuser")
	public User createEmployee(@RequestBody User user)
	{
		userService.createUser(user);
		return user;
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public  ResponseEntity<List<User>> deleteEmployee(@PathVariable("id") int emid) {
		
		List<User> li = userService.deleteUser(emid);
		System.out.println("User List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(li,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateuser")
	public  ResponseEntity<List<User>> updateEmployee(@RequestBody User user) {
		System.out.println("From controller ..." + user);
		List<User> li = userService.updateUser(user);
		System.out.println("User List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(li,HttpStatus.OK);
		
	}
}
