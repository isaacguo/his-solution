package com.isaac.pethospital.authentication.entities;

import org.junit.Test;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PermissionEntityTests {


    RoleEntity re = new RoleEntity();

    @Test
    public void givenPermissionEntityThenItHasFieldId() {
        PermissionEntity pe = getPermissionEntity();
        assertThat(pe, hasProperty("id", is(2L)));
    }

    @Test
    public void givenRoleEntityThenItHasFieldRole() {
        PermissionEntity pe = getPermissionEntity();
        assertThat(pe, hasProperty("roles", hasItem(re)));
    }

    private PermissionEntity getPermissionEntity() {

        PermissionEntity pe = new PermissionEntity();
        pe.setId(2L);
        pe.addRole(re);

        return pe;
    }
}
