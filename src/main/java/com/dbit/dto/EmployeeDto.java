package com.dbit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class EmployeeDto extends AbstractDto {
    private String name;
    private int salary;
}
