package com.springboot.rentroom.myapp.service;

import java.util.List;


import com.springboot.rentroom.myapp.entity.Rent;

public interface RentService {
	
	public List<Rent> findAll();
	
	public Rent findById(int theId);
	
	public void save(Rent theRent);
	
	public void deleteById(int theId);
	
}
