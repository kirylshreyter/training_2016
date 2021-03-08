package com.kirylshreyter.hotel.services;

import java.util.List;

public interface AbstractService<T> {
    Long create(T entity);

    T read(Long id);

    Boolean update(T entity);

    Integer delete(Long id);

    List<T> getAll();
}
