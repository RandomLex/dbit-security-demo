package com.dbit.dto.convertors;

import com.dbit.dto.AbstractDto;
import com.dbit.model.AbstractEntity;

import java.util.List;
import java.util.stream.Collectors;

public interface ModelDtoConvertor<T extends AbstractEntity, R extends AbstractDto> {
    R convert(T t);

    default List<R> convert(List<T> list) {
        return list.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
