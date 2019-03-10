package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.dtos.ReportTemplateCategoryOperationRequest;
import com.isaac.pethospital.medicaltest.entities.DepartmentEntity;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateCategoryEntity;
import com.isaac.pethospital.medicaltest.repositories.DepartmentRepository;
import com.isaac.pethospital.medicaltest.repositories.ReportTemplateCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportTemplateCategoryServiceImpl implements ReportTemplateCategoryService {
    private final ReportTemplateCategoryRepository reportTemplateCategoryRepository;
    private final DepartmentRepository departmentRepository;

    public ReportTemplateCategoryServiceImpl(ReportTemplateCategoryRepository reportTemplateCategoryRepository,
                                             DepartmentRepository departmentRepository) {
        this.reportTemplateCategoryRepository = reportTemplateCategoryRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<ReportTemplateCategoryEntity> findRoots() {
        return this.reportTemplateCategoryRepository.findByParentIsNull();
    }

    @Override
    public ReportTemplateCategoryEntity findOne(Long id) {
        return this.reportTemplateCategoryRepository.findOne(id);
    }

    @Override
    public ReportTemplateCategoryEntity create(ReportTemplateCategoryOperationRequest request) {
        Long pid = request.getParentId();
        Long departmentId = request.getDepartmentId();
        DepartmentEntity department = this.getDepartmentEntity(departmentId);

        if (pid == null) {
            ReportTemplateCategoryEntity category = new ReportTemplateCategoryEntity();
            category.setName(request.getName());
            department.addReportTemplateCategory(category);

            this.departmentRepository.save(department);
            return category;

            //return this.reportTemplateCategoryRepository.save(category);
        } else {

            ReportTemplateCategoryEntity parent = this.reportTemplateCategoryRepository.findOne(pid);
            if (parent == null)
                throw new RuntimeException("parent is null");

            ReportTemplateCategoryEntity category = new ReportTemplateCategoryEntity();
            category.setName(request.getName());

            parent.addChild(category);

            return this.reportTemplateCategoryRepository.save(parent);
        }

    }

    @Override
    public ReportTemplateCategoryEntity update(ReportTemplateCategoryOperationRequest request) {

        Long id = request.getId();
        if (id == null)
            throw new RuntimeException("id is null");
        ReportTemplateCategoryEntity entity = this.reportTemplateCategoryRepository.findOne(id);
        if (entity == null)
            throw new RuntimeException("entity is null");

        entity.setName(request.getName());
        return this.reportTemplateCategoryRepository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        if (id == null)
            throw new RuntimeException("id is null");
        ReportTemplateCategoryEntity entity = this.reportTemplateCategoryRepository.findOne(id);
        if (entity == null)
            throw new RuntimeException("entity is null");

        this.reportTemplateCategoryRepository.delete(id);
        return true;
    }

    @Override
    public List<ReportTemplateCategoryEntity> findByDepartmentId(Long depId) {
        DepartmentEntity departmentEntity = getDepartmentEntity(depId);
        return departmentEntity.getReportTemplateCategoryList();
    }

    private DepartmentEntity getDepartmentEntity(Long depId) {
        DepartmentEntity departmentEntity = this.departmentRepository.findByDepId(depId);
        if (departmentEntity == null)
            throw new RuntimeException("cannot find department by id");
        return departmentEntity;
    }
}
