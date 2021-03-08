package com.kirylshreyter.hotel.daoapi;

import java.util.List;

public interface IAbstractDao<T> {
    Long create(T entity);

    T read(Long id);

    Boolean update(T entity);

    Integer delete(Long id);

    List<T> getAll();
}
