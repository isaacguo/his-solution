package com.isaac.pethospital.authentication.entities;


import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationUserTests {

    @Test
    public void givenApplicationUserThenItHasFieldId() {
        ApplicationUser au = getApplicationUser();
        assertThat(au, hasProperty("id", is(2L)));
    }
    @Test
    public void givenApplicationUserThenItHasFieldUserName() {
        ApplicationUser au = getApplicationUser();
        assertThat(au, hasProperty("username", is("admin")));
    }
    @Test
    public void givenApplicationUserThenItHasFieldPassword() {
        ApplicationUser au = getApplicationUser();
        assertThat(au, hasProperty("password", is("admin_password")));
    }

    private ApplicationUser getApplicationUser() {

        ApplicationUser au = new ApplicationUser();

        au.setId(2L);
        au.setUsername("admin");
        au.setPassword("admin_password");

        return au;
    }
}
