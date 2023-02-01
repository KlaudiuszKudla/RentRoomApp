package com.springboot.rentroom.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.springboot.rentroom.myapp.entity.Location;
import com.springboot.rentroom.myapp.entity.Room;
import com.springboot.rentroom.myapp.entity.User;
import com.springboot.rentroom.myapp.service.LocationService;
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
@RequestMapping("/rooms")
public class RoomController {
	
	


	private RoomService roomService;
	private LocationService locationService;
	
	
	public RoomController(RoomService theRoomService,  LocationService theLocationService) {
		roomService = theRoomService;
		locationService = theLocationService;
	}
	

	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listRooms(Model theModel) {
		
		// get employees from db
		List<Room> theRooms = roomService.findAll();
		
		// add to the spring model
		theModel.addAttribute("rooms", theRooms);
		
		return "rooms/list-rooms";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Room theRoom = new Room();
		Location theLocation = new Location();
		theRoom.setLocation(theLocation);
		
		
		theModel.addAttribute("rooms", theRoom);
		
		return "rooms/room-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("roomId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Room theRoom = roomService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("rooms", theRoom);
		
		// send over to our form
		return "rooms/room-form";			
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("room") Room theRoom) {
		
		// save the employee
		roomService.save(theRoom);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/rooms/list";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("roomId") int theId) {
		
		// delete the employee
		roomService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/rooms/list";
		
	}
	
}
