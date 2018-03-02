package com.isaac.pethospital.treatment.entities;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.TestExecutionListeners;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class EmployeeEntitySpecTests {

    EmployeeEntity employeeEntity;
    EmployeeTypeEntity employeeTypeEntity;
    DepartmentEntity departmentEntity;

    @Before
    public void init() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.employeeEntity = new EmployeeEntity();
        this.departmentEntity=new DepartmentEntity();
        this.employeeTypeEntity=new EmployeeTypeEntity();

        this.employeeEntity.setName("任我行");
        this.employeeEntity.setSelfIntroduction("我是一名侠客");
        this.employeeEntity.setDepartment(this.departmentEntity);
        this.employeeEntity.setEmployeeType(this.employeeTypeEntity);

    }

    @Test
    public void givenPetEntityHasFieldName() {
        assertThat(employeeEntity, hasProperty("name", is("任我行")));
    }

    @Test
    public void givenPetEntityHasFieldSelfIntroduction() {
        assertThat(employeeEntity, hasProperty("selfIntroduction", is("我是一名侠客")));
    }

    @Test
    public void givenPetEntityHasFieldDepartment() {
        assertThat(employeeEntity, hasProperty("department", is(this.departmentEntity)));
    }

    @Test
    public void givenPetEntityHasFieldJobTitle() {
        assertThat(employeeEntity, hasProperty("employeeType", is(this.employeeTypeEntity)));
    }
}
