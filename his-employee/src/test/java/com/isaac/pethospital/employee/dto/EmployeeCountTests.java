package com.isaac.pethospital.employee.dto;

import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EmployeeCountTests {
    @Test
    public void givenEmployeeCountThenItHasFieldUserCount() {
        EmployeeCount ec = this.generateEmployeeCount();
        assertThat(ec,hasProperty("count",is(30L)));

    }

    private EmployeeCount generateEmployeeCount() {
        EmployeeCount ec = new EmployeeCount(30L);
        return ec;
    }
}
