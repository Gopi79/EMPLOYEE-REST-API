package com.employee.EMPLOYEE_REST_API.service;

import com.employee.EMPLOYEE_REST_API.Dto.EmployeeDto;
import com.employee.EMPLOYEE_REST_API.model.Employee;
import com.employee.EMPLOYEE_REST_API.repo.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmployeServiceTest
{
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;

    private EmployeeDto employeeDto;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
        employee = Employee.builder()
                .name("Alex")
                .job("Developer")
                .salary(50000.00)
                .hireDate(LocalDate.of(2021,6,18))
                .build();
        employeeDto = EmployeeDto.builder()
                .id(1L)
                .name("Alex")
                .job("Developer")
                .salary(50000.00)
                .hireDate(LocalDate.of(2021,6,18))
                .build();
    }

    @Test
    public void saveEmployeeTest()
    {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto);
        assertNotNull(saveEmployee);
        assertEquals(employee.getId(),saveEmployee.getId());
        assertEquals(employee.getName(), saveEmployee.getName());
        assertEquals(employee.getJob(), saveEmployee.getJob());
        assertEquals(employee.getSalary(), saveEmployee.getSalary());
        assertEquals(employee.getHireDate(), saveEmployee.getHireDate());
        verify(employeeRepository,times(1)).save(any(Employee.class));
    }



}
