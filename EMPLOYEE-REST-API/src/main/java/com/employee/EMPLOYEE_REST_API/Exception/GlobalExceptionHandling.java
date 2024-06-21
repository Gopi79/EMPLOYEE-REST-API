package com.employee.EMPLOYEE_REST_API.Exception;

import com.employee.EMPLOYEE_REST_API.Dto.ExceptionBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandling
{
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionBean> handleEmployeeNotFoundException(EmployeeNotFoundException exception, WebRequest webRequest)
    {
        ExceptionBean error= new ExceptionBean(webRequest.getDescription(false), HttpStatus.BAD_REQUEST,exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
