package com.isaac.pethospital.common.services;

import java.util.List;

public interface CrudService<T, R> {

    T create(R request);

    T readOne(Long id);

    List<T> readAll();

    T update( R request);

    boolean deleteOne(Long id);
}

