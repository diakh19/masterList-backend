package com.mockProject.masterListbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PassengerType",nullable = false)
    private String passengerType;

    @Column(name="full_name",nullable = false)
    private String fullName;


    @Column(name = "Gender",nullable = false)
    private String gender;

    @Column(name = "Berth Preference",nullable = false)
    private String berth;

    @Column(name = "ID type",nullable = false)
    private String idType;

    @Column(name="ID no.",nullable = false)
    private String idNumber;

    @Column(name = "Food choice",nullable = false)
    private String food;

    @Column(name = "DOB",nullable = false)
    private LocalDate dob;








}
