package com.isaac.pethospital.authentication.entities;

import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Test;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RoleEntityTests {

    PermissionEntity pe = new PermissionEntity();
    UserEntity ue = new UserEntity();

    @Test
    public void givenRoleEntityThenItHasFieldId() {
        RoleEntity re = getRoleEntity();
        assertThat(re, hasProperty("id", is(2L)));
    }

    @Test
    public void givenRoleEntityThenItHasFieldRole() {
        RoleEntity re = getRoleEntity();
        assertThat(re, hasProperty("role", is("DATA_FUll_ACCESS")));
    }
    @Test
    public void givenRoleEntityThenItHasFieldPermissions() {
        RoleEntity re = getRoleEntity();
        assertThat(re, hasProperty("permissions", hasItem(pe)));
    }
    @Test
    public void givenRoleEntityThenItHasFieldUsers() {
        RoleEntity re = getRoleEntity();
        assertThat(re, hasProperty("users", hasItem(ue)));
    }

    private RoleEntity getRoleEntity() {

        RoleEntity re = new RoleEntity();
        re.setId(2L);
        re.setRole("DATA_FUll_ACCESS");
        re.addPermission(pe);
        re.addUser(ue);
        return re;
    }
}
