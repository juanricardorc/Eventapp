package com.jualig.datasource.repository.mapper;

public interface Mapper<I, O> {
    O convert(I response);
}
