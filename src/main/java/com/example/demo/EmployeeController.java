package com.example.demo;

import com.example.demo.dto.EmployeeDto;
import com.github.mhewedy.expressions.Expressions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @PostMapping("/search")
    public ResponseEntity<Page<EmployeeDto>> search(@RequestBody Expressions expressions, Pageable pageable) {
        return ok().body(employeeRepository.findAll(expressions, pageable)
                .map(EmployeeDto::fromEntity));
    }
}
