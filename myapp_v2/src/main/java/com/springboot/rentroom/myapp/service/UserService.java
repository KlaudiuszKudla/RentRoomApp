package com.springboot.rentroom.myapp.service;

import java.util.List;

import com.springboot.rentroom.myapp.entity.Location;
import com.springboot.rentroom.myapp.entity.User;

public interface UserService {


		public List<User> findAll();
		
		public User findById(int theId);
		
		public void save(User theUser);
		
		public void deleteById(int theId);
		
		public Location findLocation(int theId);
	
}
