package com.isaac.pethospital.common.restcontrollers;

import com.isaac.pethospital.common.services.CrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AbstractCRUDRestController<T, R> implements CrudRestController<T, R> {

    protected CrudService<T, R> crudService;

    public AbstractCRUDRestController(CrudService<T, R> crudService) {
        this.crudService = crudService;
    }

    @Override
    @PostMapping
    public T create(R request) {
        return this.crudService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public T readOne(@PathVariable("id") Long id)

    {
        return this.crudService.readOne(id);
    }

    @Override
    @GetMapping
    public List<T> readAll() {
        return this.crudService.readAll();
    }

    @Override
    @PutMapping("id")
    public T update(R request) {
        return this.crudService.update(request);
    }

    @Override
    @DeleteMapping
    public boolean deleteOne(Long id) {
        return this.crudService.deleteOne(id);
    }
}
