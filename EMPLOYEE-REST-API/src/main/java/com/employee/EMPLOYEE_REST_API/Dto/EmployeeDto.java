package com.employee.EMPLOYEE_REST_API.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto
{
    private Integer id;

    @NotEmpty(message = "Please Provide Valid Name")
    private String name;

    @NotEmpty(message = "Please Provide Your Job")
    private String job;

    @NotEmpty(message = "Please Provide Your Date Of Joining")
    private LocalDate hireDate;

    @NotNull(message = "Please Provide Your Salary")
    private Double salary;
}
