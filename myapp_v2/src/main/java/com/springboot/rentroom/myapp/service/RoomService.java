package com.springboot.rentroom.myapp.service;

import java.util.List;

import com.springboot.rentroom.myapp.entity.Location;
import com.springboot.rentroom.myapp.entity.Room;

public interface RoomService {
	
	public List<Room> findAll();
	
	public Room findById(int theId);
	
	public void save(Room theRoom);
	
	public void deleteById(int theId);
	
}
