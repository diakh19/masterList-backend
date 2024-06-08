package com.mockProject.masterListbackend.CustomValidation;

import com.mockProject.masterListbackend.dto.RequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NoIdValidator implements ConstraintValidator<NoId, RequestDto> {

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(NoId constraintAnnotation){
    }
    @Override
    public boolean isValid(RequestDto dto, ConstraintValidatorContext context)
    {
    String method= request.getMethod();
    if("POST".equalsIgnoreCase(method)){
        return dto.getId()==null;
    }
    return true;
    }

}
