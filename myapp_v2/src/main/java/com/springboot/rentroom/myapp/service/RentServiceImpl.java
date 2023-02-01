package com.springboot.rentroom.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springboot.rentroom.myapp.dao.RentRepository;
import com.springboot.rentroom.myapp.entity.Rent;



@Service
public class RentServiceImpl implements RentService {

	private RentRepository rentRepository;
	
	@Autowired
	public RentServiceImpl(RentRepository theRentRepository) {
		rentRepository = theRentRepository;
	}
	
	@Override
	public List<Rent> findAll() {
			return rentRepository.findAll();
	}

	@Override
	public Rent findById(int theId) {
		Optional <Rent> result = rentRepository.findById(theId);
		
		Rent theRent = null;
		
		if (result.isPresent()) {
			theRent = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find rent id - " + theId);
			
	}
		return theRent;
	}

	@Override
	public void save(Rent theRent) {
	
			rentRepository.save(theRent);
		}

	

	@Override
	public void deleteById(int theId) {
		rentRepository.deleteById(theId);

	}

}
