package com.eshopping.decemberprojectmodulev2.advice;

import com.eshopping.decemberprojectmodulev2.dto.Errors.ErrorDto;
import com.eshopping.decemberprojectmodulev2.exceptions.Products.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        ResponseEntity<ErrorDto> response = new ResponseEntity<>(
                errorDto, HttpStatus.NOT_FOUND
        );

        return response;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
