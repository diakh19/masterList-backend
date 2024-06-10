package com.mockProject.masterListbackend.service.impl;

import com.mockProject.masterListbackend.Enum.IdType;
import com.mockProject.masterListbackend.dto.RequestDto;
import com.mockProject.masterListbackend.dto.ResponseDto;
import com.mockProject.masterListbackend.entity.Passenger;
import com.mockProject.masterListbackend.exception.DuplicateResourceException;
import com.mockProject.masterListbackend.exception.ResourceNotFoundException;

import com.mockProject.masterListbackend.repository.PassengerRepository;
import com.mockProject.masterListbackend.service.PassengerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor


public class PassengerServiceimpl implements PassengerService {

 private PassengerRepository passengerRepository;

 @Autowired
 private ModelMapper mapper;
    @Override
    public ResponseDto createPassenger(RequestDto requestDto){
        //checking duplication
        String idNumber= requestDto.getIdNumber();
        IdType idType= requestDto.getIdType();
        Passenger existing=passengerRepository.findByIdNumberAndIdType(idNumber,idType);
        if(existing!=null){
            throw new DuplicateResourceException("Duplicate resource");
        }

        else {
            Passenger p= mapper.map(requestDto,Passenger.class);
            Passenger savedPassenger=passengerRepository.save(p);
            return mapper.map(savedPassenger, ResponseDto.class);
        }
    }

    @Override
    public ResponseDto getPassengerById(Long passengerId) {
        Passenger passenger=passengerRepository.findById(passengerId).orElseThrow(()-> new ResourceNotFoundException("Passenger with given id does not exist:"+ passengerId));
        return mapper.map(passenger, ResponseDto.class);

    }

    @Override
    public List<ResponseDto> getAllPassengers() {
        List<Passenger> passengers=passengerRepository.findAll();
        return passengers.stream().map((passenger)-> mapper.map(passenger, ResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public ResponseDto updatePassenger(Long passengerId, ResponseDto updatedPassenger) {
        Passenger passenger=passengerRepository.findById(passengerId).orElseThrow(()-> new ResourceNotFoundException("Passenger with given id does not exist:"+ passengerId));

        String idNumber=updatedPassenger.getIdNumber();
        IdType idType=updatedPassenger.getIdType();

        Passenger existing=passengerRepository.findByIdNumberAndIdType(idNumber,idType);
        if(existing!=passenger && existing!=null){
            throw new DuplicateResourceException("Update Passenger is not possible.Another passenger with given IdType and IdNumber already exists in List");
        }
        else {
            passenger.setPassengerType(updatedPassenger.getPassengerType());
            passenger.setFood(updatedPassenger.getFood());
            passenger.setDob(updatedPassenger.getDOB());
            passenger.setBerth(updatedPassenger.getBerth());
            passenger.setFullName(updatedPassenger.getFullName());
            passenger.setGender(updatedPassenger.getGender());
            passenger.setIdType(updatedPassenger.getIdType());
            passenger.setIdNumber(updatedPassenger.getIdNumber());
            Passenger updatedPassengerObj=passengerRepository.save(passenger);
            return mapper.map(updatedPassengerObj, ResponseDto.class);
        }

    }

    @Override
    public void deletePassenger(Long passengerId) {
        Passenger passenger=passengerRepository.findById(passengerId).orElseThrow(()-> new ResourceNotFoundException("Passenger with given id does not exist:"+ passengerId));
        passengerRepository.deleteById(passengerId);
    }

}
