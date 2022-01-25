package com.dbit.controllers;

import com.dbit.dto.EmployeeDto;
import com.dbit.model.Employee;
import com.dbit.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employees", produces = "application/json")
@RequiredArgsConstructor
public class EmployeeJsonController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getAll() {
        return employeeService.findAll();
    }
}
