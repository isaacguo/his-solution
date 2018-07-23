package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.common.services.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractCrudService<T, R> implements CrudService<T, R> {

    protected JpaRepository<T, Long> jpaRepository;

    public AbstractCrudService(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    @Override
    public T readOne(Long id) {
        return jpaRepository.findOne(id);
    }

    @Override
    public List<T> readAll() {
        return jpaRepository.findAll();
    }


    @Override
    public boolean deleteOne(Long id) {
        jpaRepository.delete(id);
        return true;
    }
}
