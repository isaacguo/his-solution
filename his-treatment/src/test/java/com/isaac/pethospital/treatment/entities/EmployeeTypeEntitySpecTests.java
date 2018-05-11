package com.isaac.pethospital.treatment.entities;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class EmployeeTypeEntitySpecTests {

    EmployeeTypeEntity employeeTypeEntity;

    @Before
    public void init() {
        this.employeeTypeEntity = new EmployeeTypeEntity();
        this.employeeTypeEntity.setName("操作员");
    }

    @Test
    public void givenPetEntityHasFieldName() {
        assertThat(employeeTypeEntity, hasProperty("name", is("操作员")));
    }

}
