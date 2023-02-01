package com.springboot.rentroom.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rentroom.myapp.dao.UserRepository;
import com.springboot.rentroom.myapp.entity.Location;
import com.springboot.rentroom.myapp.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}
	
	@Override
	public List<User> findAll() {
			return userRepository.findAll();
	}

	@Override
	public User findById(int theId) {
		Optional <User> result = userRepository.findById(theId);
		
		User theUser = null;
		
		if (result.isPresent()) {
			theUser = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find user id - " + theId);
			
	}
		return theUser;
	}

	@Override
	public void save(User theUser) {
	
			userRepository.save(theUser);
		}

	

	@Override
	public void deleteById(int theId) {
		userRepository.deleteById(theId);

	}

	@Override
	public Location findLocation(int theId) {
	
		return null;
	}

	

}
