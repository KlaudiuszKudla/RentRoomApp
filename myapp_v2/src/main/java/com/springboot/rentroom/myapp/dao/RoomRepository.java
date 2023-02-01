package com.springboot.rentroom.myapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rentroom.myapp.entity.Room;
import com.springboot.rentroom.myapp.entity.User;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	

}
