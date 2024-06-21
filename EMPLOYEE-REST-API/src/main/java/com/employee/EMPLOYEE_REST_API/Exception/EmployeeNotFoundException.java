package com.employee.EMPLOYEE_REST_API.Exception;

public class EmployeeNotFoundException extends RuntimeException
{
    public EmployeeNotFoundException(String message)
    {
        super(message);
    }
}
