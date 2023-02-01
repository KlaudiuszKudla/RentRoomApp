package com.springboot.rentroom.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rentroom.myapp.dao.LocationRepository;
import com.springboot.rentroom.myapp.entity.Location;


@Service
public class LocationServiceImpl implements LocationService {

	private LocationRepository locationRepository;
	
	@Autowired
	public LocationServiceImpl(LocationRepository theLocationRepository) {
		locationRepository = theLocationRepository;
	}
	
	@Override
	public List<Location> findAll() {
			return locationRepository.findAll();
	}

	@Override
	public Location findById(int theId) {
		Optional <Location> result = locationRepository.findById(theId);
		
		Location theLocation = null;
		
		if (result.isPresent()) {
			theLocation = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find location id - " + theId);
			
	}
		return theLocation;
	}

	@Override
	public void save(Location theLocation) {
	
			locationRepository.save(theLocation);
		}

	

	@Override
	public void deleteById(int theId) {
		locationRepository.deleteById(theId);

	}

}
