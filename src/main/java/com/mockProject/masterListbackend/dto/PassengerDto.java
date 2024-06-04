package com.mockProject.masterListbackend.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Data
public class PassengerDto {

    private Long id;

    @NotBlank(message = "passenger Type is mandatory")
    private String passengerType;

    @NotBlank(message = "Name is mandatory")
    @Size(min=2,max=25,message="Name length should be between 2 and 25.")
    private String fullName;


    @NotBlank(message = "Gender is mandatory")
    private String Gender;

    @NotBlank(message = "Berth preference is mandatory")
    private String Berth;


    @NotBlank(message = "idType is mandatory")
    private String idType;

    @NotBlank(message = "id Number is mandatory")
    @Size(min = 10,max=10,message = "Id number must be exactly 10 characters long")
    private String idNumber;

    @NotBlank(message = "Food choice  is mandatory")
    private String Food;


    @NotNull(message = "DOB is mandatory")
    @Past(message = "DOB must be in past")
    private LocalDate DOB;

}
