package com.dbit.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AbstractDto {
    protected Integer id;
}
