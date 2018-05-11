package com.isaac.pethospital.treatment.services;


import com.isaac.pethospital.treatment.dtos.EmployeeTypeOperationRequest;
import com.isaac.pethospital.treatment.entities.EmployeeTypeEntity;
import com.isaac.pethospital.treatment.repositories.EmployeeTypeRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class EmployeeTypeServiceSpecTests {

    EmployeeTypeService employeeTypeService;
    EmployeeTypeRepository employeeTypeRepository;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        employeeTypeRepository = mock(EmployeeTypeRepository.class);
        employeeTypeService = spy(new EmployeeTypeServiceImpl(employeeTypeRepository));
    }

    @Test
    public void givenEmployeeTypeOperationRequestThenCreateEmployeeTypeEntity() {
        //given
        EmployeeTypeOperationRequest employeeTypeOperationRequest = new EmployeeTypeOperationRequest();
        employeeTypeOperationRequest.setName("任我行");
        doReturn(null).when(employeeTypeRepository).findByName("任我行");
        //when
        this.employeeTypeService.createEmployeeType(employeeTypeOperationRequest);
        //then
        verify(employeeTypeRepository, times(1)).findByName("任我行");
        verify(employeeTypeRepository, times(1)).save(any(EmployeeTypeEntity.class));
    }

    @Test
    public void givenEmployeeTypeOperationRequestThenDeleteEmployeeTypeEntity() {
        //given
        EmployeeTypeOperationRequest employeeTypeOperationRequest = new EmployeeTypeOperationRequest();
        employeeTypeOperationRequest.setId(1L);
        doReturn(true).when(employeeTypeRepository).exists(1L);
        //when
        this.employeeTypeService.deleteEmployeeType(employeeTypeOperationRequest);
        //then
        verify(employeeTypeRepository, times(1)).exists(1L);
        verify(employeeTypeRepository, times(1)).delete(1L);
    }

    @Test
    public void givenEmployeeTypeOperationRequestThenUpdateEmployeeTypeEntity() {
        //given
        EmployeeTypeOperationRequest employeeTypeOperationRequest = new EmployeeTypeOperationRequest();
        employeeTypeOperationRequest.setName("任我行");
        employeeTypeOperationRequest.setId(1L);
        doReturn(true).when(employeeTypeRepository).exists(1L);
        doReturn(new EmployeeTypeEntity()).when(employeeTypeRepository).findOne(1L);
        //when
        this.employeeTypeService.updateEmployeeType(employeeTypeOperationRequest);
        //then
        verify(employeeTypeRepository, times(1)).exists(1L);
        verify(employeeTypeRepository, times(1)).save(any(EmployeeTypeEntity.class));
    }

    @Test
    public void givenEmployeeTypeOperationRequestThenFindEmployeeTypeEntityByName() {
        //given
        EmployeeTypeOperationRequest employeeTypeOperationRequest = new EmployeeTypeOperationRequest();
        employeeTypeOperationRequest.setName("任我行");
        doReturn(new EmployeeTypeEntity()).when(employeeTypeRepository).findByName("任我行");
        //when
        this.employeeTypeService.findByName(employeeTypeOperationRequest);
        //then
        verify(employeeTypeRepository, times(1)).findByName("任我行");
    }
}
