package com.mockProject.masterListbackend.controller;

import com.mockProject.masterListbackend.dto.RequestDto;
import com.mockProject.masterListbackend.dto.ResponseDto;
import com.mockProject.masterListbackend.service.PassengerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private PassengerService passengerService;

    //build add passenger REST API
  @PostMapping
    public ResponseEntity<?> createPassenger(@Valid @RequestBody RequestDto requestDto,BindingResult bindingResult)
    {

        if(bindingResult.hasErrors()){
            Map<String,String> errors=new HashMap<>();
            for(FieldError error:bindingResult.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        ResponseDto savedPassenger=passengerService.createPassenger(requestDto);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);

    }

    //Build get Passenger REST API
    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getPassengerById(@PathVariable("id") Long passengerId){
      ResponseDto responseDto =passengerService.getPassengerById(passengerId);
      return ResponseEntity.ok(responseDto);
    }

    //Build Get All Passengers REST API
    @GetMapping
    public ResponseEntity<List<ResponseDto>> getAllPassengers(){
      List<ResponseDto> responseDtoList = passengerService.getAllPassengers();
      return ResponseEntity.ok(responseDtoList);
    }

    //Build update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<ResponseDto> updatePassenger(@PathVariable("id") Long passengerId, @Valid @RequestBody RequestDto updatedPassenger)
    {
        ResponseDto p= passengerService.updatePassenger(passengerId,updatedPassenger);
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
