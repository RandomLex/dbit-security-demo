package com.dbit.services;

import com.dbit.dto.EmployeeDto;
import com.dbit.dto.convertors.DtoModelConvertor;
import com.dbit.dto.convertors.ModelDtoConvertor;
import com.dbit.model.Employee;
import com.dbit.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;
    private final ModelDtoConvertor<Employee, EmployeeDto> employeeModelDtoConvertor;

    public List<EmployeeDto> findAll() {
        return employeeModelDtoConvertor.covert(repository.findAll());
    }
}
