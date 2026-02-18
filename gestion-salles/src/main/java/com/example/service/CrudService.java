package com.example.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {

    T create(T entity);

    Optional<T> getById(ID id);

    List<T> getAll();

    T edit(T entity);

    void remove(T entity);

    void removeById(ID id);
}
