package com.springboot.rentroom.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.springboot.rentroom.myapp.entity.Location;
import com.springboot.rentroom.myapp.service.LocationService;

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
@RequestMapping("/locations")
public class LocationController {
	
	


	private LocationService locationService;
	
	
	public LocationController(LocationService theLocationService) {
		locationService = theLocationService;
	}
	

	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listLocations(Model theModel) {
		
		// get employees from db
		List<Location> theLocations = locationService.findAll();
		
		// add to the spring model
		theModel.addAttribute("locations", theLocations);
		
		return "locations/list-locations";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Location theLocation = new Location();
		
		theModel.addAttribute("locations", theLocation);
		
		return "/locations/location-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("locationId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Location theLocation = locationService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("locations", theLocation);
		
		// send over to our form
		return "locations/location-form";			
	}
	
	
	@PostMapping("/save")
	public String saveLocation(@ModelAttribute("location") Location theLocation) {
		
		// save the employee
		locationService.save(theLocation);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/locations/list";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("locationId") int theId) {
		
		// delete the employee
		locationService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/locations/list";
		
	}
	
	@PostMapping("/theLocation")
	public String showTheLocation(@RequestParam("locationId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Location theLocation = locationService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("location", theLocation);
		
		// send over to our form
		return "location";			
	}
	
}
