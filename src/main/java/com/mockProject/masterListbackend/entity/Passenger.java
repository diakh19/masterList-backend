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

    @Column(name = "PassengerType")
    private String passengerType;

    @Column(name="full_name")
    private String fullName;


    @Column(name = "Gender")
    private String gender;

    @Column(name = "Berth Preference")
    private String berth;


    @Column(name = "ID type")
    private String idType;

    @Column(name="ID no.")
    private String idNumber;

    @Column(name = "Food choice")
    private String food;



    @Column(name = "DOB")
    private LocalDate dob;








}
