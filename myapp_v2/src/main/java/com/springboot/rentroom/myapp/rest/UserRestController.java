package com.springboot.rentroom.myapp.rest;

import java.util.List;

import org.apache.tomcat.util.json.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rentroom.myapp.entity.User;
import com.springboot.rentroom.myapp.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	private UserService userService;
		
	
	@GetMapping("users")
	public List<User> getUsers(){
		
		return userService.findAll();
	}
	
	@GetMapping("users/{userId}")
	public User getUser(@PathVariable int userId) {
		
		User theUser = userService.findById(userId);
		
		if(theUser ==null){
			throw new UserNotFoundException("User id not found - " + userId);
		}
		
		return theUser;
		}
	
	@PostMapping("users")
	public User addUser(@RequestBody User theUser) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
	//	theUser.setId(0);
		
		userService.save(theUser);
		
		return theUser;
	}
	
	@PutMapping("users")
	public User updateUser(@RequestBody User theUser) {
		
		userService.save(theUser);
		
		return theUser;
		
	}
	
	// add mapping for DELETE /customers/{customerId} - delete customer
	
	@DeleteMapping("users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		
		User tempUser = userService.findById(userId);
		
		// throw exception if null
		
		if (tempUser == null) {
			throw new UserNotFoundException("User id not found - " + userId);
		}
				
		userService.deleteById(userId);
		
		return "Deleted user id - " + userId;
	}
}
	
	
	

