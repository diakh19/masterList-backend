package com.mockProject.masterListbackend.mapper;

import com.mockProject.masterListbackend.dto.PassengerDto;
import com.mockProject.masterListbackend.entity.Passenger;

public class PassengerMapper {

    public static PassengerDto mapToPassengerDto(Passenger passenger)
    {
        return new PassengerDto(
                passenger.getId(),
                passenger.getPassengerType(),
                passenger.getFullName(),
                passenger.getGender(),
                passenger.getBerth(),
                passenger.getIdType(),
                passenger.getIdNumber(),
                passenger.getFood(),
                passenger.getDob()

        );
    }

    public static Passenger mapToPassenger(PassengerDto passengerDto)
    {
        return new Passenger(
                passengerDto.getId(),
                passengerDto.getPassengerType(),
                passengerDto.getFullName(),
                passengerDto.getGender(),
                passengerDto.getBerth(),
                passengerDto.getIdType(),
                passengerDto.getIdNumber(),
                passengerDto.getFood(),
                passengerDto.getDOB()

        );
    }
}
