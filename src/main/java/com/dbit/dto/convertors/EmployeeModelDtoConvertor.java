package com.dbit.dto.convertors;

import com.dbit.dto.EmployeeDto;
import com.dbit.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeModelDtoConvertor implements ModelDtoConvertor<Employee, EmployeeDto> {

    @Override
    public EmployeeDto convert(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .salary(employee.getSalary())
                .build();
    }
}
