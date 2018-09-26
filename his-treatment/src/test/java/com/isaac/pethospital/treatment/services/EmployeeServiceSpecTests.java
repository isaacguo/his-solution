package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.treatment.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.EmployeeTypeEntity;
import com.isaac.pethospital.treatment.repositories.DepartmentRepository;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.EmployeeTypeRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class EmployeeServiceSpecTests {

    EmployeeService employeeService;
    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;
    EmployeeTypeRepository employeeTypeRepository;
    JmsProperties jmsProperties;
    JmsSender jmsSender;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        employeeRepository = mock(EmployeeRepository.class);
        departmentRepository = mock(DepartmentRepository.class);
        employeeTypeRepository = mock(EmployeeTypeRepository.class);
        jmsProperties=mock(JmsProperties.class);
        jmsSender=mock(JmsSender.class);
        employeeService = spy(new EmployeeServiceImpl(employeeRepository,employeeTypeRepository,departmentRepository,jmsProperties,
                               jmsSender));
    }

    @Test
    public void givenEmployeeOperationRequestWhenCreateThenThrowRuntimeExceptionIfDepartmentIdIsNull() {
        //given
        EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();
        //expected
        exception.expect(RuntimeException.class);
        exception.expectMessage("No Department Info.");
        //when
        this.employeeService.createEmployee(employeeOperationRequest);
    }

    @Test
    public void givenEmployeeOperationRequestWhenCreateThenThrowRuntimeExceptionIfDepartmentCannotBeFound() {
        //given
        EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();
        employeeOperationRequest.setDepartmentId(1L);
        doReturn(null).when(departmentRepository).findOne(employeeOperationRequest.getDepartmentId());
        //expected
        exception.expect(RuntimeException.class);
        exception.expectMessage("Cannot Find Department.");
        //when
        this.employeeService.createEmployee(employeeOperationRequest);
    }




    @Test
    public void givenEmployeeOperationRequestThenCreateEmployeeEntity() {
        //given
        EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();
        employeeOperationRequest.setDepartmentId(1L);
        employeeOperationRequest.setName("任我行");
        employeeOperationRequest.setDepartmentId(1L);

        doReturn(new DepartmentEntity()).when(departmentRepository).findByDepId(employeeOperationRequest.getDepartmentId());
        //when
        this.employeeService.createEmployee(employeeOperationRequest);
        //then
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
        employeeOperationRequest.setName("任我行");
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
    public void givenLoginAccountWhenFindEmployeeEntityByLoginAccountThenThrowRuntimeExceptionIfNotFound() {
        //given
        String loginAccount="doctorunittest";
        doReturn(null).when(employeeRepository).findByLoginAccount(loginAccount);
        //expection
        exception.expect(RuntimeException.class);
        exception.expectMessage("The Employee with loginAccount: doctorunittest cannot be found");
        //when
        this.employeeService.findByLoginAccount(loginAccount);
    }
    @Test
    public void givenLoginAccountThenFindEmployeeEntityByLoginAccount() {
        //given
        String loginAccount="doctorunittest";
        doReturn(new EmployeeEntity()).when(employeeRepository).findByLoginAccount(loginAccount);
        //when
        this.employeeService.findByLoginAccount(loginAccount);
        //then
        verify(employeeRepository, times(1)).findByLoginAccount(loginAccount);
    }


    @Test
    public void givenEmployeeOperationRequestThenFindEmployeeEntityByName() {
        //given
        EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();
        employeeOperationRequest.setName("任我行");
        List<EmployeeEntity> list = new LinkedList<>();
        doReturn(list).when(employeeRepository).findByName("任我行");
        //when
        this.employeeService.findByName(employeeOperationRequest);
        //then
        verify(employeeRepository, times(1)).findByName("任我行");
    }

    @Test
    public void givenEmployeeOperationRequestThenFindEmployeeEntityByEmployeeType() {
        //given
        EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();
        employeeOperationRequest.setEmployeeTypeId(1L);
        List<EmployeeEntity> list = new LinkedList<>();
        EmployeeTypeEntity employeeTypeEntity=new EmployeeTypeEntity();
        employeeTypeEntity.setName("操作员");
        doReturn(employeeTypeEntity).when(employeeTypeRepository).findOne(employeeOperationRequest.getEmployeeTypeId());
        doReturn(list).when(employeeRepository).findByEmployeeType(employeeTypeEntity);
        //when
        this.employeeService.findByEmployeeType(employeeOperationRequest);
        //then
        verify(employeeRepository, times(1)).findByEmployeeType(any(EmployeeTypeEntity.class));
    }


    @Test
    public void givenEmployeeOperationRequestThenFindEmployeeListByDepartment() {
        //given
        DepartmentEntity departmentEntity = new DepartmentEntity();
        List<DepartmentEntity> list = new LinkedList<>();
        list.add(departmentEntity);

        EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();
        employeeOperationRequest.setDepartmentId(1L);
        employeeOperationRequest.setName("任我行");
        doReturn(departmentEntity).when(departmentRepository).findByDepId(1L);
        doReturn(list).when(employeeRepository).findByDepartment(departmentEntity);
        //when
        this.employeeService.findByDepartment(employeeOperationRequest);
        //then
        verify(employeeRepository, times(1)).findByDepartment(any(DepartmentEntity.class));
    }
}
