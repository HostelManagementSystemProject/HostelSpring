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

import com.mph.entity.User;
import com.mph.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}, allowedHeaders = "*")
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/allusers")
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
	public User createUser(@RequestBody User user)
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
	
	@GetMapping("/searchuser/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int user_id) {
		User user = userService.searchUser(user_id);
		System.out.println("User : " + user);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	
	@GetMapping("/userdetails/{email}/{password}")
	public ResponseEntity<User> getUser(@PathVariable("email") String email_id,@PathVariable("password") String password) {
		User u = userService.getUserEmail(email_id,password);
		System.out.println("User : " + u);
		return new ResponseEntity<User>(u, HttpStatus.OK);

	}
	
	@GetMapping("/getuserbyid/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int user_id) {
		User user = userService.getUserById(user_id);
		System.out.println("User : " + user);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
}
