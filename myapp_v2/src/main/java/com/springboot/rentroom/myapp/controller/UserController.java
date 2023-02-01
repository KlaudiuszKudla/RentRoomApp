package com.springboot.rentroom.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.springboot.rentroom.myapp.entity.Location;
import com.springboot.rentroom.myapp.entity.User;
import com.springboot.rentroom.myapp.service.LocationService;
import com.springboot.rentroom.myapp.service.UserService;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@Controller
@RequestMapping("/users")
public class UserController {
	
	


	private UserService userService;
	private LocationService locationService;
	
	
	public UserController(UserService theUserService, LocationService theLocationService ) {
		userService = theUserService;
		locationService = theLocationService;
	}
	

	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listUsers(Model theModel) {
		
		// get employees from db
		List<User> theUsers = userService.findAll();
		
		// add to the spring model
		theModel.addAttribute("users", theUsers);
		
		return "users/list-users";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		User theUser = new User();
		Location theLocation = new Location();
		theUser.setLocation(theLocation);
		
	//	theModel.addAttribute("location",theLocation);
		theModel.addAttribute("users", theUser);
		
		return "/users/user-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId,
									Model theModel) {
		
		// get the employee from the service
		User theUser = userService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("users", theUser);
		
		// send over to our form
		return "users/user-form";			
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("user") User theUser) {
	
		// save the employee
		userService.save(theUser);
	
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/users/list";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("userId") int theId) {
		
		// delete the employee
		userService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/users/list";
		
	}
	
	
	
	
	
}
