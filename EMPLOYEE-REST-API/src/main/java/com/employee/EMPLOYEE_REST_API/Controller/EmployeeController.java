package com.employee.EMPLOYEE_REST_API.Controller;

import com.employee.EMPLOYEE_REST_API.Dto.EmployeeDto;
import com.employee.EMPLOYEE_REST_API.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/emp")
@Validated
public class EmployeeController
{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        return  new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }
    @GetMapping("/get/{empId}")
    public ResponseEntity<EmployeeDto> getAEmloyee(@PathVariable Integer empId)
    {
        return  new ResponseEntity<>(employeeService.getAEmployee(empId),HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }
    @PutMapping("/fullupdate/{empId}")
    public ResponseEntity<EmployeeDto> fullUpdateEmployee(@PathVariable Integer empId, @RequestBody EmployeeDto employeeDto)
    {
        return new ResponseEntity<>(employeeService.fullUpdateEmployee(empId,employeeDto),HttpStatus.OK);
    }
    @PatchMapping("/partiallyupdate/{empId}")
    public ResponseEntity<EmployeeDto> partiallyUpdate(@PathVariable Integer empId,@RequestBody EmployeeDto employeeDto)
    {
        return new ResponseEntity<>(employeeService.partiallyUpdate(empId,employeeDto),HttpStatus.OK);
    }
    @DeleteMapping("/deleteemployee/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId)
    {
        return new ResponseEntity<>(employeeService.deleteEmployee(empId),HttpStatus.OK);
    }
}
