package com.isaac.pethospital.employee.repositories;

import com.isaac.pethospital.employee.PersistenceConfig;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = PersistenceConfig.class)
public class EmployeeRepositorySpecTests {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository repository;

    @Before
    public void init() {
    }

    @Test
    public void whenFindDistinctEmployeeNamesThenReturnListOfEmployeeNames() {
        EmployeeEntity e1 = new EmployeeEntity();
        e1.setGivenName("郭");
        e1.setSurname("文李");
        e1.setFullName(e1.getSurname() + e1.getGivenName());

        EmployeeEntity e2 = new EmployeeEntity();
        e2.setGivenName("李");
        e2.setSurname("文明");
        e2.setFullName(e2.getSurname() + e2.getGivenName());

        this.entityManager.persist(e1);
        this.entityManager.persist(e2);

        List<EmployeeEntity> list = this.repository.findDistinctByFullNameContains("李");
        assertThat(list.size()).isEqualTo(2);


    }
}
