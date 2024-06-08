package com.mockProject.masterListbackend.repository;

import com.mockProject.masterListbackend.Enum.IdType;
import com.mockProject.masterListbackend.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
    Passenger findByIdNumberAndIdType(String idNumber, IdType idType);
}
