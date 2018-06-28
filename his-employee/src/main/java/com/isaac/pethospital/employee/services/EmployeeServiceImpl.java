package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.common.dtos.JmsEmployeeOperationRequest;
import com.isaac.pethospital.common.enums.OperationEnum;
import com.isaac.pethospital.common.jms.JmsAuthorizationProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.employee.dto.EmployeeListItem;
import com.isaac.pethospital.employee.dto.EmployeeOperationRequest;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.repositories.DepartmentRepository;
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

        moveToTargetDepartmentInternal(de, ee);

        this.employeeRepository.save(ee);
        return true;
    }

    @Override
    public EmployeeOperationRequest getMyInfo() {
        String userAccount = this.getUserAccount();
        EmployeeEntity ee = this.employeeRepository.findByLoginAccount(userAccount);
        if (ee == null)
            throw new RuntimeException("Cannot find Employee by uuid");
        return EmployeeOperationRequest.convertToDto(ee);
    }

    @Override
    public EmployeeOperationRequest getEmployeeByUuid(String uuid) {
        EmployeeEntity ee = this.employeeRepository.findByUuid(uuid);
        if (ee == null)
            throw new RuntimeException("Cannot find Employee by uuid");
        return EmployeeOperationRequest.convertToDto(ee);
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
    public boolean moveEmployeeToDepartment(Long empId, Long depId) {

        boolean isManager = false;
        DepartmentEntity targetDepartment = this.departmentService.findById(depId);
        if (targetDepartment == null)
            throw new RuntimeException("Cannot Find Department");

        EmployeeEntity ee = employeeRepository.findOne(empId);
        if (ee == null)
            throw new RuntimeException("Cannot Find Employee");

        if (ee.getDepartment() == targetDepartment)
            return true;

        DepartmentEntity departmentInCharge = ee.getDepartmentInCharge();
        if (departmentInCharge != null) {                            //if this employee is the manager of the old department and the last one of it, then move it
            if (departmentInCharge.getEmployees().size() == 1) {
                departmentInCharge.removeManager(ee);
                departmentService.getDepartmentRepository().save(departmentInCharge);
            } else {
                throw new RuntimeException("Manager cannot move");
            }
        }


        moveToTargetDepartmentInternal(targetDepartment, ee);


        employeeRepository.save(ee);


        return true;
    }

    private void moveToTargetDepartmentInternal(DepartmentEntity targetDepartment, EmployeeEntity ee) {
        if (targetDepartment.getManager() == null) {     //the first employee of current department

            if (targetDepartment.getParent() == null)        // the root department
                ee.setDirectReportTo(this.getSentinelEmployee());
            else                            // not the first employee created
                ee.setDirectReportTo(targetDepartment.getParent().getManager());
            ee.setDepartmentInCharge(targetDepartment);
        } else {                             // not the first employee to be created
            ee.setDirectReportTo(targetDepartment.getManager());
        }

        ee.setDepartment(targetDepartment);
    }

    @Override
    public boolean setAsManager(Long id) {

        EmployeeEntity employeeEntity = this.employeeRepository.findOne(id);
        if (employeeEntity == null)
            throw new RuntimeException("Cannot find employee");

        DepartmentEntity department = employeeEntity.getDepartment();

        EmployeeEntity manager = employeeEntity.getDepartment().getManager();
        if (manager == null)
            throw new RuntimeException("Cannot find employee's manager");

        EmployeeEntity director = manager.getDirectReportTo();
        if (director == null)
            throw new RuntimeException("Cannot find employee's manager's director");

        if (employeeEntity == manager)
            return true;

        List<EmployeeEntity> teams = manager.getTeamMembers();

        manager.removeAllTeamMembers();
        manager.setDepartmentInCharge(null);

        employeeEntity.setDirectReportTo(director);

        teams.forEach(r -> {
            if (r != employeeEntity) {
                employeeEntity.addTeamMember(r);
                employeeRepository.save(r);
            }
        });
        employeeEntity.addTeamMember(manager);
        employeeRepository.save(manager);
        employeeRepository.save(employeeEntity);

        department.setManager(employeeEntity);

        departmentService.getDepartmentRepository().save(department);


        return false;
    }

    @Override
    public String findByTitle(EmployeeOperationRequest request) {

        if (request.getSearchByTitle().equals("总经理"))
            return this.departmentService.findById(this.departmentService.findRootDepartment().getId()).getManager().getLoginAccount();
        else
            throw new RuntimeException("Error to find manager");
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
        return this.employeeRepository.findDistinctByFullNameHanYuPinYinContains(keyword);
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


    public EmployeeEntity getSentinelEmployee() {
        return this.employeeRepository.getSentinelEmployee();
    }
}
