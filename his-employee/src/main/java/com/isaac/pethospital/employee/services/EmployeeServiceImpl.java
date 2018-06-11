package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.common.dtos.JmsEmployeeOperationRequest;
import com.isaac.pethospital.common.enums.OperationEnum;
import com.isaac.pethospital.common.jms.JmsAuthorizationProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.employee.dto.EmployeeListItem;
import com.isaac.pethospital.employee.dto.EmployeeOperationRequest;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.repositories.EmployeeRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JmsSender jmsSender;
    private final JmsAuthorizationProperties jmsAuthorizationProperties;

    private String getUserAccount() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentService departmentService, BCryptPasswordEncoder bCryptPasswordEncoder, JmsSender jmsSender, JmsAuthorizationProperties jmsAuthorizationProperties) {
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jmsSender = jmsSender;
        this.jmsAuthorizationProperties = jmsAuthorizationProperties;
    }

    @Override
    public long getTotalCounts() {
        return this.employeeRepository.count();
    }

    @Override
    public EmployeeEntity getEmployeeById(long id) {
        return this.employeeRepository.findOne(id);
    }

    @Override
    public boolean createEmployee(EmployeeOperationRequest request) {
        String uuid = UUID.randomUUID().toString();
        EmployeeEntity ee = request.toEmployeeEntity();
        ee.setPassword(bCryptPasswordEncoder.encode(request.getLoginAccount()));

        if (request.getDepartmentId() == null)
            throw new RuntimeException("Department Id is null");
        DepartmentEntity de = this.departmentService.findById(request.getDepartmentId());
        if (de == null)
            throw new RuntimeException("Department is null");

        ee.setUuid(uuid);
        ee.setDepartment(de);

        if (de.getManager() == null) {
            ee.setDepartmentInCharge(de);
            Long rootId = this.departmentService.findRootDepartment().getId();
            DepartmentEntity root = this.departmentService.findById(rootId);
            ee.setDirectReportTo(root.getManager());
        } else {
            ee.setDirectReportTo(de.getManager());
        }

        this.employeeRepository.save(ee);
        return true;
    }

    @Override
    public EmployeeEntity getMyInfo() {
        String userAccount = this.getUserAccount();
        return this.employeeRepository.findByLoginAccount(userAccount);
    }

    @Override
    public EmployeeEntity getEmployeeByUuid(String uuid) {
        return this.employeeRepository.findByUuid(uuid);
    }

    @Override
    public List<String> getOrganizationNames() {
        return null;
    }

    @Override
    public List<String> getSupportedRelationships() {
        return null;
    }

    @Override
    public EmployeeOperationRequest findUserNameByLoginAccount(String loginAccount) {
        EmployeeEntity ee = this.employeeRepository.findByLoginAccount(loginAccount);
        if (ee != null) {
            EmployeeOperationRequest eor = new EmployeeOperationRequest();
            eor.setLoginAccount(ee.getLoginAccount());
            eor.setPassword(ee.getPassword());
            return eor;
        } else
            return null;
    }


    @Override
    public EmployeeOperationRequest findUserNameByUserAccount(String userAccount) {
        EmployeeEntity ee = this.employeeRepository.findByLoginAccount(userAccount);
        if (ee != null) {
            EmployeeOperationRequest eor = new EmployeeOperationRequest();
            eor.setFullName(ee.getFullName());
            return eor;
        } else
            throw new RuntimeException("Cannot find UserAccount");
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity ee = null;

        if (this.employeeRepository.exists(id)) {
            ee = this.employeeRepository.findOne(id);
            this.employeeRepository.delete(id);

            JmsEmployeeOperationRequest jmsEmployeeOperationRequest = new JmsEmployeeOperationRequest(OperationEnum.DELETE, ee.getId(), ee.getFullName(), ee.getLoginAccount());
            this.jmsSender.sendEvent(this.jmsAuthorizationProperties.getEmployeeUseraccountOperationTopic(), jmsEmployeeOperationRequest);
        }

        return true;
    }

    @Override
    public boolean updateEmployee(EmployeeOperationRequest request) {
        if (!this.employeeRepository.exists(request.getId()))
            throw new RuntimeException("Employee doesn't exist");

        EmployeeEntity employeeEntity = this.employeeRepository.findOne(request.getId());
        request.updateEmployee(employeeEntity);
        this.employeeRepository.save(employeeEntity);

        JmsEmployeeOperationRequest jmsEmployeeOperationRequest = new JmsEmployeeOperationRequest(OperationEnum.UPDATE, employeeEntity.getId(), employeeEntity.getFullName(), employeeEntity.getLoginAccount());
        this.jmsSender.sendEvent(this.jmsAuthorizationProperties.getEmployeeUseraccountOperationTopic(), jmsEmployeeOperationRequest);

        return true;
    }

    @Override
    public boolean updateLoginAccount(EmployeeOperationRequest request) {
        if (!this.employeeRepository.exists(request.getId()))
            throw new RuntimeException("Employee doesn't exist");

        EmployeeEntity employeeEntity = this.employeeRepository.findOne(request.getId());
        employeeEntity.setLoginAccount(request.getLoginAccount());
        this.employeeRepository.save(employeeEntity);


        JmsEmployeeOperationRequest jmsEmployeeOperationRequest = new JmsEmployeeOperationRequest(OperationEnum.UPDATE, employeeEntity.getId(), employeeEntity.getFullName(), employeeEntity.getLoginAccount());
        this.jmsSender.sendEvent(this.jmsAuthorizationProperties.getEmployeeUseraccountOperationTopic(), jmsEmployeeOperationRequest);
        return true;


    }

    @Override
    public boolean updatePassword(EmployeeOperationRequest request) {
        if (!this.employeeRepository.exists(request.getId()))
            throw new RuntimeException("Employee doesn't exist");

        EmployeeEntity employeeEntity = this.employeeRepository.findOne(request.getId());
        employeeEntity.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        this.employeeRepository.save(employeeEntity);
        return true;
    }


    @Override
    public EmployeeEntity findBySurnameAndGivenName(EmployeeOperationRequest request) {
        return this.employeeRepository.findBySurnameAndGivenName(request.getSurname(), request.getGivenName());
    }

    @Override
    public boolean setReportTo(Long employeeId, Long managerId) {
        EmployeeEntity ee = this.employeeRepository.findOne(employeeId);
        EmployeeEntity manager = this.employeeRepository.findOne(managerId);
        if (ee == null)
            throw new RuntimeException("Employee cannot be found");
        if (manager == null)
            throw new RuntimeException("Manager cannot be found");

        if (ee.getDirectReportTo() != null) {
            ee.getDirectReportTo().removeTeamMember(ee);
        }
        manager.addTeamMember(ee);
        this.employeeRepository.save(manager);
        return true;
    }

    @Override
    public List<EmployeeEntity> findKeywordInName(String keyword) {
        return this.employeeRepository.findDistinctByFullNameContains(keyword);
    }

    @Override
    public List<EmployeeListItem> findEmployeesForEmployeeListItem() {
        return this.employeeRepository.findEmployeesForEmployeeListItem();
    }

    @Override
    public String getDirectManagerUserAccount(String userAccount) {

        EmployeeEntity ee = this.employeeRepository.findByLoginAccount(userAccount);
        return ee.getDirectReportTo().getLoginAccount();
    }

    @Override
    public Long getDepartmentId(String userAccount) {
        EmployeeEntity ee = this.employeeRepository.findByLoginAccount(userAccount);
        if (ee == null) return -1L;
        if (ee.getDepartment() == null)
            return -2L;
        return ee.getDepartment().getId();
    }

    @Override
    public List<EmployeeListItem> findEmployeesForEmployeeListItemByDepartmentId(Long departmentId) {
        return this.employeeRepository.findEmployeesForEmployeeListItemByDepartmentId(departmentId);
    }


}
