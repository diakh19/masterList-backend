package com.mockProject.masterListbackend.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mockProject.masterListbackend.CustomDeserializer.BerthDeserializer;
import com.mockProject.masterListbackend.CustomDeserializer.FoodDeserializer;
import com.mockProject.masterListbackend.CustomDeserializer.PassengerTypeDeserializer;
import com.mockProject.masterListbackend.CustomSerializer.BerthSerializer;
import com.mockProject.masterListbackend.CustomSerializer.FoodSerializer;
import com.mockProject.masterListbackend.CustomSerializer.PassengerTypeSerializer;
import com.mockProject.masterListbackend.Enum.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import com.mockProject.masterListbackend.CustomValidation.NoId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Data
@NoId(message="ID field should not be present in the request")
public class RequestDto {


     private Long id;

    //    @NotBlank(message = "passenger Type is mandatory")
    @Enumerated(EnumType.STRING)
    @JsonSerialize(using = PassengerTypeSerializer.class)
    @JsonDeserialize(using = PassengerTypeDeserializer.class)
    private PassengerType passengerType;

    //    @NotBlank(message = "Name is mandatory")
    @Size(min=2,max=25,message="Name length should be between 2 and 25.")
    private String fullName;


    //    @NotBlank(message = "Gender is mandatory")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    //    @NotBlank(message = "Berth preference is mandatory")
    @Enumerated(EnumType.STRING)
    @JsonSerialize(using = BerthSerializer.class)
    @JsonDeserialize(using = BerthDeserializer.class)
    private Berth berth;


    //    @NotBlank(message = "idType is mandatory")
    @Enumerated(EnumType.STRING)
    private IdType idType;

    @NotBlank(message = "id Number is mandatory")
    @Size(min = 10,max=10,message = "Id number must be exactly 10 characters long")
    private String idNumber;

    //    @NotBlank(message = "Food choice  is mandatory")
    @Enumerated(EnumType.STRING)
    @JsonSerialize(using = FoodSerializer.class)
    @JsonDeserialize(using = FoodDeserializer.class)
    private Food food;


    @NotNull(message = "DOB is mandatory")
    @Past(message = "DOB must be in past")
    private LocalDate DOB;
}
