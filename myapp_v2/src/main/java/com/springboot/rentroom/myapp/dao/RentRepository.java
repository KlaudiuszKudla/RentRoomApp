package com.springboot.rentroom.myapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rentroom.myapp.entity.Rent;

public interface RentRepository extends JpaRepository<Rent, Integer> {

}
