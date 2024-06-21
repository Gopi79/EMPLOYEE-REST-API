package com.employee.EMPLOYEE_REST_API.service;

import com.employee.EMPLOYEE_REST_API.Dto.EmployeeDto;
import com.employee.EMPLOYEE_REST_API.Exception.EmployeeNotFoundException;
import com.employee.EMPLOYEE_REST_API.model.Employee;
import com.employee.EMPLOYEE_REST_API.repo.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService
{

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    //Post Method
    public EmployeeDto saveEmployee(EmployeeDto employeeDto)
    {
        Employee employee=Employee
                .builder()
                .job(employeeDto.getJob())
                .name(employeeDto.getName())
                .salary(employeeDto.getSalary())
                .hireDate(employeeDto.getHireDate())
                .build();
        employeeRepository.save(employee);
        return EmployeeDto
                .builder()
                .id(employee.getId())
                .name(employee.getName())
                .salary(employee.getSalary())
                .job(employee.getJob())
                .hireDate(employee.getHireDate())
                .build();
    }

    //Get Method
    public EmployeeDto getAEmployee(Integer empId)
    {
        Optional<Employee> result = employeeRepository.findById(empId);
        if(result.isPresent())
        {
            Employee employee = result.get();

            return EmployeeDto
                    .builder()
                    .id(employee.getId())
                    .name(employee.getName())
                    .salary(employee.getSalary())
                    .job(employee.getJob())
                    .hireDate(employee.getHireDate())
                    .build();
        }
        else
        {
            throw new EmployeeNotFoundException("Employee Not Found with This Id: "+empId);
        }
    }

    //Get All Employees
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee : allEmployees) {
            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employee, employeeDto);
            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }

    //Put Employee
    public EmployeeDto fullUpdateEmployee(Integer empId,EmployeeDto employeeDto)
    {
        Optional<Employee> employee = employeeRepository.findById(empId);
        if(employee.isPresent())
        {
            Employee emp ;
            emp=Employee
                    .builder()
                    .id(employeeDto.getId())
                    .job(employeeDto.getJob())
                    .name(employeeDto.getName())
                    .salary(employeeDto.getSalary())
                    .hireDate(employeeDto.getHireDate())
                    .build();
            employeeRepository.save(emp);
            return EmployeeDto
                    .builder()
                    .id(emp.getId())
                    .name(emp.getName())
                    .salary(emp.getSalary())
                    .job(emp.getJob())
                    .hireDate(emp.getHireDate())
                    .build();
        }
        else
        {
            throw new EmployeeNotFoundException("Employee Not Found With This Id: "+empId);
        }
    }

    //Patch Employee
    public  EmployeeDto partiallyUpdate(Integer empId,EmployeeDto employeeDto)
    {
        Optional<Employee> employee = employeeRepository.findById(empId);
        if(employee.isPresent())
        {
            Employee emp = employee.get();

            if (employeeDto.getName() != null) {
                emp.setName(employeeDto.getName());
            }
            if (employeeDto.getJob() != null) {
                emp.setJob(employeeDto.getJob());
            }
            if (employeeDto.getSalary() != null) {
                emp.setSalary(employeeDto.getSalary());
            }
            if (employeeDto.getHireDate() != null) {
                emp.setHireDate(employeeDto.getHireDate());
            }
            employeeRepository.save(emp);
            return EmployeeDto
                    .builder()
                    .id(emp.getId())
                    .name(emp.getName())
                    .salary(emp.getSalary())
                    .job(emp.getJob())
                    .hireDate(emp.getHireDate())
                    .build();
        }
        else
        {
            throw new EmployeeNotFoundException("Employee Not Found With This Id: "+empId);
        }
    }

    //Delete Employee
    public String deleteEmployee(Integer empId)
    {
        Optional<Employee> emp = employeeRepository.findById(empId);
        if (emp.isPresent())
        {
            employeeRepository.deleteById(empId);
            return "Employee Deleted Successfully";
        }
        else
        {
            throw new EmployeeNotFoundException("Employee Not Found With This Id: "+empId);
        }
    }
}
