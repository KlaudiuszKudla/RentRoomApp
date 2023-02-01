package com.springboot.rentroom.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.springboot.rentroom.myapp.entity.Location;
import com.springboot.rentroom.myapp.entity.Rent;
import com.springboot.rentroom.myapp.entity.Room;
import com.springboot.rentroom.myapp.entity.User;
import com.springboot.rentroom.myapp.service.LocationService;
import com.springboot.rentroom.myapp.service.RentService;
import com.springboot.rentroom.myapp.service.RoomService;
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
@RequestMapping("/rents")
public class RentController {
	
	


	private RentService rentService;
	private UserService userService;

	
	
	public RentController(RentService theRentService,  UserService theUserService) {
		rentService = theRentService;
		userService = theUserService;
	}
	

	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listRents(Model theModel) {
		
		// get employees from db
		List<Rent> theRents = rentService.findAll();
		
		// add to the spring model
		theModel.addAttribute("rents", theRents);
		
		return "rents/list-rents";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Room theRoom = new Room();
		Rent theRent = new Rent();
		theRent.addRoom(theRoom);
		
		
		theModel.addAttribute("rents", theRent);
		
		return "rooms/room-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("rentId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Rent theRent = rentService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("rents", theRent);
		
		// send over to our form
		return "rents/rent-form";			
	}
	
	
	@PostMapping("/save")
	public String saveRent(@ModelAttribute("rent") Rent theRent) {
		
		// save the employee
		rentService.save(theRent);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/rents/list";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("rentId") int theId) {
		
		// delete the employee
		rentService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/rents/list";
		
	}
	
}
