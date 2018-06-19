package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.entities.DepartmentEntity;
import com.isaac.pethospital.medicaltest.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public boolean setDepartmentEnable(DepartmentEntity department) {
        DepartmentEntity de = this.departmentRepository.findByDepId(department.getDepId());
        if (de == null)
            de = new DepartmentEntity();
        de.setEnable(department.isEnable());
        de.setDepId(department.getDepId());
        de.setName(department.getName());
        this.departmentRepository.save(de);
        return true;
    }

    @Override
    public DepartmentEntity getDepartmentByDepId(Long depId) {
        DepartmentEntity de = this.departmentRepository.findByDepId(depId);
        if (de != null)
            return de;
        else {
            DepartmentEntity newDe = new DepartmentEntity();
            newDe.setDepId(depId);
            newDe.setEnable(false);
            return newDe;
        }
    }
}
