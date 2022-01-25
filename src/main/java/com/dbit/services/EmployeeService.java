package com.dbit.services;

import com.dbit.dto.EmployeeDto;
import com.dbit.dto.convertors.ModelDtoConvertor;
import com.dbit.model.Employee;
import com.dbit.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;
    private final ModelDtoConvertor<Employee, EmployeeDto> employeeModelDtoConvertor;

    public List<EmployeeDto> findAll() {
        return employeeModelDtoConvertor.convert(repository.findAll());
    }

    public Optional<EmployeeDto> findByName(String name) {
        Optional<Employee> employee = repository.findByName(name);
        return employee.map(employeeModelDtoConvertor::convert);
    }
}
