package com.isaac.pethospital.authentication.entities;

import org.junit.Test;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserEntityTests {


    RoleEntity re = new RoleEntity();
    @Test
    public void givenUserEntityThenItHasFieldId() {
        UserEntity ue = getUserEntity();
        assertThat(ue, hasProperty("id", is(2L)));
    }
    @Test
    public void givenUserEntityThenItHasFieldUserId()
    {
        UserEntity ue = getUserEntity();
        assertThat(ue, hasProperty("userId", is("asdfs0asdfo")));
    }
    @Test
    public void givenUserEntityThenItHasFieldUserName()
    {
        UserEntity ue = getUserEntity();
        assertThat(ue, hasProperty("userName", is("admin")));
    }
    @Test
    public void givenUserEntityThenItHasFieldRole()
    {
        UserEntity ue = getUserEntity();
        assertThat(ue, hasProperty("roles", hasItem(re)));
    }

    private UserEntity getUserEntity() {

        UserEntity ue = new UserEntity();

        ue.setId(2L);
        ue.setUserId("asdfs0asdfo");
        ue.setUserName("admin");
        ue.addRole(re);


        return ue;
    }
}
