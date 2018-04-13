package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.dto.EmployeeOperationRequest;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.enums.SexualEnum;
import com.isaac.pethospital.employee.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class EmployeeServiceSpecTests {

    EmployeeRepository employeeRepository;
    EmployeeService employeeService;

    @Before
    public void before() {
        this.employeeRepository = mock(EmployeeRepository.class);
        this.employeeService = spy(new EmployeeServiceImpl(this.employeeRepository));
    }

    @Test
    public void givenEmployeeOperationRequestThenCreateEmployeeEntity() {
        //given
        EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();
        employeeOperationRequest.setSurname("Isaac");
        employeeOperationRequest.setGivenName("Guo");
        //doReturn(null).when(employeeRepository).findBySurnameAndGivenName(any(String.class),any(String.class));
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
        this.employeeService.deleteEmployee(employeeOperationRequest);
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
