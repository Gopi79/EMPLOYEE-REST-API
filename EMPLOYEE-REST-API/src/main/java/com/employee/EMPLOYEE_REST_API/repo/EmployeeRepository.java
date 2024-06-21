package com.employee.EMPLOYEE_REST_API.repo;

import com.employee.EMPLOYEE_REST_API.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
