package com.mockProject.masterListbackend.service.impl;

import com.mockProject.masterListbackend.dto.PassengerDto;
import com.mockProject.masterListbackend.entity.Passenger;
import com.mockProject.masterListbackend.exception.ResourceNotFoundException;
import com.mockProject.masterListbackend.mapper.PassengerMapper;
import com.mockProject.masterListbackend.repository.PassengerRepository;
import com.mockProject.masterListbackend.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PassengerServiceimpl implements PassengerService {

 private PassengerRepository passengerRepository;
    @Override
    public PassengerDto createPassenger(PassengerDto passengerDto) {

        Passenger p= PassengerMapper.mapToPassenger(passengerDto);
        Passenger savedPassenger=passengerRepository.save(p);
        return PassengerMapper.mapToPassengerDto(savedPassenger);
    }

    @Override
    public PassengerDto getPassengerById(Long passengerId) {
        Passenger passenger=passengerRepository.findById(passengerId).orElseThrow(()-> new ResourceNotFoundException("Passenger with given id does not exist:"+ passengerId));
        return PassengerMapper.mapToPassengerDto(passenger);

    }

    @Override
    public List<PassengerDto> getAllPassengers() {
        List<Passenger> passengers=passengerRepository.findAll();
        return passengers.stream().map((passenger)-> PassengerMapper.mapToPassengerDto(passenger)).collect(Collectors.toList());
    }

    @Override
    public PassengerDto updatePassenger(Long passengerId, PassengerDto updatedPassenger) {
        Passenger passenger=passengerRepository.findById(passengerId).orElseThrow(()-> new ResourceNotFoundException("Passenger with given id does not exist:"+ passengerId));

        passenger.setId(passengerId);
        passenger.setPassengerType(updatedPassenger.getPassengerType());

        passenger.setFood(updatedPassenger.getFood());
        passenger.setDob(updatedPassenger.getDOB());
        passenger.setBerth(updatedPassenger.getBerth());
        passenger.setFullName(updatedPassenger.getFullName());
        passenger.setGender(updatedPassenger.getGender());
        passenger.setIdType(updatedPassenger.getIdType());
        passenger.setIdNumber(updatedPassenger.getIdNumber());
        passenger.setSeniorCitizen(updatedPassenger.isSeniorCitizen());

        Passenger updatedPassengerObj=passengerRepository.save(passenger);
        return PassengerMapper.mapToPassengerDto(updatedPassengerObj);
    }

    @Override
    public void deletePassenger(Long passengerId) {
        Passenger passenger=passengerRepository.findById(passengerId).orElseThrow(()-> new ResourceNotFoundException("Passenger with given id does not exist:"+ passengerId));

        passengerRepository.deleteById(passengerId);

    }
}
