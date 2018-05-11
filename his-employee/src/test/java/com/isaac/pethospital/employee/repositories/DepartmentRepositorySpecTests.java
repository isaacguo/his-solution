package com.isaac.pethospital.employee.repositories;

import com.isaac.pethospital.employee.PersistenceConfig;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import org.assertj.core.internal.DeepDifference;
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
public class DepartmentRepositorySpecTests {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DepartmentRepository repository;

    @Before
    public void init() {
    }

    private DepartmentEntity generator(String name) {
        DepartmentEntity de = new DepartmentEntity();
        de.setName(name);
        return de;
    }

    @Test
    public void whenFindDistinctDepartmentNamesThenReturnListOfDepartmentNames() {
        DepartmentEntity de = generator("总经理");

        de.addChild(generator("采购部"));
        de.addChild(generator("办公室"));
        DepartmentEntity de2 = generator("业务部");
        de2.addChild(generator("外科"));
        de.addChild(de2);
        de.addChild(generator("财务科"));
        de.addChild(generator("采购部"));

        this.entityManager.persist(de);

        List<String> departments=this.repository.findDistinctDepartmentNames();
        assertThat(departments.size()).isEqualTo(6);


    }

}
