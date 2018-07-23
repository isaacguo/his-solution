package com.isaac.pethospital.common.restcontrollers;

import java.util.List;

public interface CrudRestController<T, R> {

    T create(R request);

    T readOne(Long id);

    List<T> readAll();

    T update(R request);

    boolean deleteOne(Long id);

}
