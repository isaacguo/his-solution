package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.dto.EmployeeOperationRequest;
import com.isaac.pethospital.employee.dto.MyDepartmentIdAndNameAndChildren;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.enums.SexualEnum;
import com.isaac.pethospital.employee.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class EmployeeServiceSpecTests {

    EmployeeRepository employeeRepository;
    EmployeeService employeeService;
    DepartmentService departmentService;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void before() {
        this.employeeRepository = mock(EmployeeRepository.class);
        this.departmentService=mock(DepartmentService.class);
        this.bCryptPasswordEncoder=mock(BCryptPasswordEncoder.class);
        this.employeeService = spy(new EmployeeServiceImpl(this.employeeRepository,this.departmentService,this.bCryptPasswordEncoder));
    }

    @Test
    public void givenEmployeeOperationRequestThenCreateEmployeeEntity() {
        //given
        EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();
        employeeOperationRequest.setSurname("Isaac");
        employeeOperationRequest.setGivenName("Guo");
        employeeOperationRequest.setDepartmentId(1L);
        doReturn(new DepartmentEntity()).when(departmentService).findById(any(Long.class));
        DepartmentEntity departmentEntity=new DepartmentEntity();
        departmentEntity.setId(1L);
        MyDepartmentIdAndNameAndChildren myDepartmentIdAndNameAndChildren=new MyDepartmentIdAndNameAndChildren();
        myDepartmentIdAndNameAndChildren.setId(1L);
        doReturn(myDepartmentIdAndNameAndChildren).when(this.departmentService).findRootDepartment();
        doReturn(departmentEntity).when(this.departmentService).findById(1L);
        //when
        this.employeeService.createEmployee(employeeOperationRequest);
        //then
        //verify(employeeRepository, times(1)).findBySurnameAndGivenName(any(String.class),any(String.class));
        verify(employeeRepository, times(1)).save(any(EmployeeEntity.class));
    }

    @Test
    public void givenEmployeeOperationRequestThenDeleteEmployeeEntity() {
        //given
        EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();
        employeeOperationRequest.setId(1L);
        doReturn(true).when(employeeRepository).exists(1L);
        //when
        this.employeeService.deleteEmployee(1L);
        //then
        verify(employeeRepository, times(1)).exists(1L);
        verify(employeeRepository, times(1)).delete(1L);
    }

    @Test
    public void givenEmployeeOperationRequestThenUpdateEmployeeEntity() {
        //given
        EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();
        employeeOperationRequest.setGender(SexualEnum.MALE);
        employeeOperationRequest.setId(1L);
        doReturn(true).when(employeeRepository).exists(1L);
        doReturn(new EmployeeEntity()).when(employeeRepository).findOne(1L);
        //when
        this.employeeService.updateEmployee(employeeOperationRequest);
        //then
        verify(employeeRepository, times(1)).exists(1L);
        verify(employeeRepository, times(1)).save(any(EmployeeEntity.class));
    }

    @Test
    public void givenEmployeeOperationRequestThenFindEmployeeEntityByName() {
        //given
        EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();
        //when
        this.employeeService.findBySurnameAndGivenName(employeeOperationRequest);
        //then
        verify(employeeRepository, times(1)).findBySurnameAndGivenName(any(String.class),any(String.class));
    }

    @Test
    public void givenTwoIdWhenSetEmployeeReportToRelationshipThenDoIt()
    {
        //given
        doReturn(new EmployeeEntity()).when(this.employeeRepository).findOne(any(Long.class));
        //when
        this.employeeService.setReportTo(any(Long.class),any(Long.class));
        //then
        verify(employeeRepository,times(2)).findOne(any(Long.class));
        verify(employeeRepository,times(1)).save(any(EmployeeEntity.class));
    }

    @Test
    public void ds()
    {
        //when
        this.employeeService.findKeywordInName(any(String.class));
        //then
        verify(this.employeeRepository,times(1)).findDistinctByFullNameContains(any(String.class));
    }

}
