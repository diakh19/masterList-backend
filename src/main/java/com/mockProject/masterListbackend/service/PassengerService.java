package com.mockProject.masterListbackend.service;

import com.mockProject.masterListbackend.dto.RequestDto;
import com.mockProject.masterListbackend.dto.ResponseDto;

import java.util.List;

public interface PassengerService {

    ResponseDto createPassenger(RequestDto requestDto);


    ResponseDto getPassengerById(Long passengerId);

    List<ResponseDto> getAllPassengers();

    ResponseDto updatePassenger(Long passengerId, ResponseDto updatedPassenger);


    void deletePassenger(Long passengerId);


}
