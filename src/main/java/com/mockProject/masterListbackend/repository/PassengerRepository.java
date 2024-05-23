package com.mockProject.masterListbackend.repository;

import com.mockProject.masterListbackend.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
