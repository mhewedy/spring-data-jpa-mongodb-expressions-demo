package com.example.demo.dto;

import com.example.demo.model.Employee;
import com.example.demo.model.LingualString;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public class EmployeeDto {
    public Long id;
    public String firstName;
    public String lastName;
    public LingualString name;
    public LocalDate birthDate;
    public Integer age;
    public Instant hireDate;
    public Short type;
    public Boolean active;
    public UUID serial;

    public static EmployeeDto fromEntity(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.id = employee.id;
        dto.firstName = employee.firstName;
        dto.lastName = employee.lastName;
        dto.name = employee.name;
        dto.birthDate = employee.birthDate;
        dto.age = employee.age;
        dto.hireDate = employee.hireDate;
        dto.type = employee.type;
        dto.active = employee.active;
        dto.serial = employee.serial;
        return dto;
    }
}
