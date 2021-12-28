package com.dhia.springsocialmediaapi.services;

import java.util.List;

public interface CrudService<T, ID> {

    List<T> findAll();

    T findById(ID id);

    T update(ID id, T object);

    T save(T object);

    void delete(ID id);

}
