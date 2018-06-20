package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.dtos.DepartmentOperationRequest;
import com.isaac.pethospital.medicaltest.dtos.DepartmentReportTemplateOperationRequest;
import com.isaac.pethospital.medicaltest.entities.DepartmentEntity;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import com.isaac.pethospital.medicaltest.repositories.DepartmentRepository;
import com.isaac.pethospital.medicaltest.repositories.ReportTemplateRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ReportTemplateRepository reportTemplateRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ReportTemplateRepository reportTemplateRepository) {
        this.departmentRepository = departmentRepository;
        this.reportTemplateRepository = reportTemplateRepository;
    }

    @Override
    public boolean setDepartmentEnable(DepartmentOperationRequest department) {
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

    @Override
    public boolean operateSupportedTestReportTemplate(DepartmentReportTemplateOperationRequest request, boolean addOperation) {
        DepartmentEntity de = this.departmentRepository.findByDepId(request.getDepId());
        if (de == null)
            throw new RuntimeException("Cannot find Department");
        ReportTemplateEntity rte = this.reportTemplateRepository.findOne(request.getTestReportTemplateId());
        if (rte == null)
            throw new RuntimeException("Cannot find ReportTemplateEntity");

        if (addOperation) {
            de.addSupportedReportTemplate(rte);
        }
        else
            de.removeSupportedReportTemplate(rte);
        this.departmentRepository.save(de);
        return true;
    }
}
