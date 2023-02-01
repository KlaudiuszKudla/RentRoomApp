package com.springboot.rentroom.myapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rentroom.myapp.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
