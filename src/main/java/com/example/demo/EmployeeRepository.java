package com.example.demo;

import com.example.demo.model.Employee;
import com.github.mhewedy.expressions.ExpressionsRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ExpressionsRepository<Employee, Long> {
}
