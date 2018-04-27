package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.dto.DepartmentIdAndName;
import com.isaac.pethospital.employee.dto.DepartmentIdAndNameAndChildren;
import com.isaac.pethospital.employee.dto.DepartmentOperationRequest;
import com.isaac.pethospital.employee.dto.MyDepartmentIdAndNameAndChildren;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import com.isaac.pethospital.employee.repositories.DepartmentRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentEntity> findAll() {
        return this.departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity findById(Long id) {
        return this.departmentRepository.findOne(id);
    }

    @Override
    public List<DepartmentIdAndName> findIndexAndNameOnly() {
        return this.departmentRepository.findAllProjectedForDepartmentIdAndName();
    }

    @Override
    public MyDepartmentIdAndNameAndChildren findRootDepartment() {

        DepartmentIdAndName root = this.departmentRepository.findRootDepartment();

        MyDepartmentIdAndNameAndChildren dc = toMyDepartmentIdAndNameAndChildren(root);
        return dc;

    }

    @Override
    public boolean createDepartment(DepartmentOperationRequest request) {

        Long parentId = request.getParentId();
        String name = request.getName();

        if (StringUtils.isEmpty(name))
            throw new RuntimeException("Department name is null");
        DepartmentEntity de = this.departmentRepository.findByName(name);
        if (de != null)
            throw new RuntimeException("Department with name:" + name + " has existed");
        if (parentId == null)
            throw new RuntimeException("Parent Department Id is null");
        DepartmentEntity parent = this.departmentRepository.findOne(parentId);
        if (parent == null)
            throw new RuntimeException("Parent Department is null");
        parent.addChildByName(name);
        this.departmentRepository.save(parent);
        return true;
    }

    @Override
    public boolean deleteDepartment(Long id) {
        this.departmentRepository.delete(id);
        return true;
    }

    @Override
    public boolean renameDepartment(DepartmentOperationRequest request) {
        if(StringUtils.isEmpty(request.getName()))
        {
            throw new RuntimeException("Name is empty");
        }
        Long id = request.getId();
        if (id == null)
            throw new RuntimeException("Department Id is null");
        DepartmentEntity de = this.departmentRepository.findOne(id);
        if (de == null)
            throw new RuntimeException("Department is null");

        de.setName(request.getName());
        this.departmentRepository.save(de);
        return true;
    }

    private MyDepartmentIdAndNameAndChildren toMyDepartmentIdAndNameAndChildren(DepartmentIdAndName departmentIdAndName) {
        MyDepartmentIdAndNameAndChildren m = new MyDepartmentIdAndNameAndChildren();
        m.setName(departmentIdAndName.getName());
        m.setId(departmentIdAndName.getId());

        this.departmentRepository.findChildDepartments(departmentIdAndName.getId()).forEach(r -> {
            m.addChildren(toMyDepartmentIdAndNameAndChildren(r));
        });
        return m;
    }


}


