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
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	
	/**
	 * This method gets the list of users
	 * @author Meghana
	 * @return returns the list of users
	 */
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
	
	
	/**
	 * This method creates the user
	 * @author Meghana
	 * @param user this is the parameter used to create user
	 * @return returns user
	 */
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user)
	{
		userService.createUser(user);
		return user;
	}
	
	
	/**
	 * This method delete a specific user
	 * @author Meghana
	 * @param emid this is the parameter used to delete user
	 * @return returns the list of users
	 */
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
	
	
	/**
	 * This method is used to update user details
	 * @author Meghana
	 * @param user this is the parameter used to update user
	 * @return returns the list of users
	 */
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
	
	
	/**
	 * This method is used to search user details
	 * @author Meghana
	 * @param user_id this is the parameter used to search user
	 * @return returns user
	 */
	@GetMapping("/searchuser/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int user_id) {
		User user = userService.searchUser(user_id);
		System.out.println("User : " + user);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	
	
	/**
	 * This method is used to get user email and password
	 * @author Meghana
	 * @param email_id password are the parameters used to get a specific user
	 * @return returns user
	 */
	@GetMapping("/userdetails/{email}/{password}")
	public ResponseEntity<User> getUser(@PathVariable("email") String email_id,@PathVariable("password") String password) {
		User u = userService.getUserEmail(email_id,password);
		System.out.println("User : " + u);
		return new ResponseEntity<User>(u, HttpStatus.OK);

	}
	
	
	/**
	 * This method is used to get user details
	 * @author Meghana
	 * @param user_id this is the parameter used to get user
	 * @return returns user
	 */
	@GetMapping("/getuserbyid/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int user_id) {
		User user = userService.getUserById(user_id);
		System.out.println("User : " + user);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
}
