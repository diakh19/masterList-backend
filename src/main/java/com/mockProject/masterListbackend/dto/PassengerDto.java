package com.mockProject.masterListbackend.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PassengerDto {

    private Long id;
    private String passengerType;


    private String fullName;



    private String Gender;


    private String Berth;



    private String idType;


    private String idNumber;


    private String Food;


    private boolean isSeniorCitizen;


    private LocalDate DOB;

}
