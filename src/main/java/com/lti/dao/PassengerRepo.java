package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Integer>{

}
