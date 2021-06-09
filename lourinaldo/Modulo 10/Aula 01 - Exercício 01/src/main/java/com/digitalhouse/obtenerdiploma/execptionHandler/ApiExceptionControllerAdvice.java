package com.digitalhouse.obtenerdiploma.execptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request){
        List<ValidationError> validationErrorList = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            validationErrorList.add(new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()));
        });

        return new ResponseEntity<List>(validationErrorList, HttpStatus.BAD_REQUEST);
    }
}
