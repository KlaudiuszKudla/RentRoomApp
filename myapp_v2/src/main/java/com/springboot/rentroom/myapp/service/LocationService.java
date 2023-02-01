package com.springboot.rentroom.myapp.service;

import java.util.List;

import com.springboot.rentroom.myapp.entity.Location;

public interface LocationService {
	
	public List<Location> findAll();
	
	public Location findById(int theId);
	
	public void save(Location theLocation);
	
	public void deleteById(int theId);
	
}
