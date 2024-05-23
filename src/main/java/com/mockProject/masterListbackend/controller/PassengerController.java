package com.mockProject.masterListbackend.controller;

import com.mockProject.masterListbackend.dto.PassengerDto;
import com.mockProject.masterListbackend.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private PassengerService passengerService;

    //build add passenger REST API
  @PostMapping
    public ResponseEntity<PassengerDto> createPassenger(@RequestBody PassengerDto passengerDto)
    {
        PassengerDto savedPassenger=passengerService.createPassenger(passengerDto);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    }

    //Build get Passenger REST API
    @GetMapping("{id}")
    public ResponseEntity<PassengerDto> getPassengerById(@PathVariable("id") Long passengerId){
      PassengerDto passengerDto=passengerService.getPassengerById(passengerId);
      return ResponseEntity.ok(passengerDto);
    }

    //Build Get All Passengers REST API
    @GetMapping
    public ResponseEntity<List<PassengerDto>> getAllPassengers(){
      List<PassengerDto> passengerDtoList= passengerService.getAllPassengers();
      return ResponseEntity.ok(passengerDtoList);
    }

    //Build update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<PassengerDto> updatePassenger(@PathVariable("id") Long passengerId,@RequestBody PassengerDto updatedPassenger)
    {
        PassengerDto p= passengerService.updatePassenger(passengerId,updatedPassenger);
        return  ResponseEntity.ok(p);
    }

    //Build Delete passenger REST API
     @DeleteMapping("{id}")
     public ResponseEntity<String> deletePassenger(@PathVariable("id") Long passengerId)
     {
       passengerService.deletePassenger(passengerId);
       return ResponseEntity.ok("Passenger deleted successfully!.");
     }
}
