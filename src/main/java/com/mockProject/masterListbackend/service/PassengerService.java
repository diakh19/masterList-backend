package com.mockProject.masterListbackend.service;

import com.mockProject.masterListbackend.dto.PassengerDto;

import java.util.List;

public interface PassengerService {

    PassengerDto createPassenger(PassengerDto passengerDto);

    PassengerDto getPassengerById(Long passengerId);

    List<PassengerDto> getAllPassengers();

    PassengerDto updatePassenger(Long passengerId,PassengerDto updatedPassenger);

    void deletePassenger(Long passengerId);

}
