package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.EmployeeTypeEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositorySpecTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository repository;


    EmployeeEntity employeeEntity1;
    EmployeeEntity employeeEntity2;
    EmployeeEntity employeeEntity3;
    EmployeeTypeEntity employeeTypeEntity1;
    EmployeeTypeEntity employeeTypeEntity2;
    DepartmentEntity departmentEntity1;
    DepartmentEntity departmentEntity2;

    @Before
    public void init() {
        employeeEntity1=new EmployeeEntity();
        employeeEntity1.setLoginAccount("doctorunitest");
        employeeEntity2=new EmployeeEntity();
        employeeEntity3=new EmployeeEntity();

        employeeTypeEntity1=new EmployeeTypeEntity();
        employeeTypeEntity2=new EmployeeTypeEntity();

        departmentEntity1=new DepartmentEntity();
        departmentEntity2=new DepartmentEntity();


        employeeEntity1.setDepartment(departmentEntity1);
        employeeEntity1.setEmployeeType(employeeTypeEntity1);
        employeeEntity2.setDepartment(departmentEntity1);
        employeeEntity2.setEmployeeType(employeeTypeEntity2);
        employeeEntity3.setDepartment(departmentEntity2);
        employeeEntity3.setEmployeeType(employeeTypeEntity2);

        this.entityManager.persist(employeeEntity1);
        this.entityManager.persist(employeeEntity2);
        this.entityManager.persist(employeeEntity3);

        this.entityManager.persist(departmentEntity1);
        this.entityManager.persist(departmentEntity2);


        this.entityManager.persist(employeeTypeEntity1);
        this.entityManager.persist(employeeTypeEntity2);

    }

    @Test
    public void givenLoginAccountWhenFindByLoginAccountThenReturnEmployeeEntity() throws Exception {
        EmployeeEntity doctor = this.repository.findByLoginAccount("doctorunitest");
        assertThat(doctor).isNotNull();
    }

    @Test
    public void givenEmployeeRepositoryWhenFindByDepartmentThenReturnList() throws Exception {

        List<EmployeeEntity> list = this.repository.findByDepartment(departmentEntity1);
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void givenEmployeeRepositoryWhenFindByEmployeeTypeThenReturnList() throws Exception {

        List<EmployeeEntity> list = this.repository.findByEmployeeType(employeeTypeEntity2);
        assertThat(list.size()).isEqualTo(2);
    }
}
