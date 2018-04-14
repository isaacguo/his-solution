package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.PersistenceConfig;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.RegistrationNumberEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = PersistenceConfig.class)
public class RegistrationNumberRepositorySpecTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RegistrationNumberRepository repository;

    LocalDate localDate;
    LocalDate localDate2;
    EmployeeEntity doctor1;
    RegistrationNumberEntity registrationNumberEntity;

    @Before
    public void init() {
        this.localDate = LocalDate.of(2018,3,1);
        this.localDate2 = LocalDate.of(2018,3,1);

        this.doctor1 = new EmployeeEntity();
        this.doctor1.setName("黄蓉");

        registrationNumberEntity = new RegistrationNumberEntity();
        registrationNumberEntity.setDoctor(this.doctor1);
        registrationNumberEntity.setDate(this.localDate);
        registrationNumberEntity.setNumber(1);

        this.entityManager.persist(doctor1);
        this.entityManager.persist(registrationNumberEntity);

    }

    @Test
    public void givenRegistrationNumberRepositoryWhenFindByDoctorThenReturnList() throws Exception {
        List<RegistrationNumberEntity> list = this.repository.findByDoctor(this.doctor1);
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void givenRegistrationNumberRepositoryWhenFindByDoctorAndDateThenReturnEntity() throws Exception {
        RegistrationNumberEntity registrationNumberEntity = this.repository.findByDoctorAndDate(this.doctor1, this.localDate);
        assertThat(registrationNumberEntity).isNotNull();
        assertThat(registrationNumberEntity.getNumber()).isEqualTo(1);
    }


}

