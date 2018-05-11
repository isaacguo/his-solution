package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.PersistenceConfig;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = PersistenceConfig.class)
public class RegistrationRepositorySpecTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RegistrationRepository repository;

    RegistrationEntity registration1;
    RegistrationEntity registration2;
    RegistrationEntity registration3;
    EmployeeEntity doctor1;
    EmployeeEntity doctor2;

    LocalDateTime localDateTime1;
    LocalDateTime localDateTime2;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Before
    public void init() {
        this.localDateTime1 = LocalDateTime.parse("2018-03-01 09:10:00", formatter);
        this.localDateTime2 = LocalDateTime.parse("2018-02-28 23:59:00", formatter);

        this.doctor1 = new EmployeeEntity();
        this.doctor1.setName("岳不群");
        this.registration1 = new RegistrationEntity();
        this.registration1.setDoctor(this.doctor1);
        this.registration1.setBookDate(this.localDateTime1);

        this.doctor2 = new EmployeeEntity();
        this.doctor2.setName("黄老邪");
        this.registration2 = new RegistrationEntity();
        this.registration2.setDoctor(this.doctor2);
        this.registration2.setBookDate(this.localDateTime1);


        this.registration3 = new RegistrationEntity();
        this.registration3.setDoctor(this.doctor1);
        this.registration3.setBookDate(this.localDateTime2);

        this.entityManager.persist(doctor1);
        this.entityManager.persist(doctor2);
        this.entityManager.persist(registration1);
        this.entityManager.persist(registration2);
        this.entityManager.persist(registration3);

    }

    @Test
    public void givenRegistrationRepositoryWhenFindByDoctorThenReturnList() throws Exception {
        List<RegistrationEntity> list = this.repository.findByDoctor(this.doctor1);
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void givenRegistrationRepositoryWhenFindByTodayAndDoctorThenReturnList() throws Exception {
        LocalDateTime today = LocalDateTime.parse("2018-03-01 00:00:00", formatter);
        List<RegistrationEntity> list = this.repository.findByDoctorAndBookDateAfter(this.doctor2, today);
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getDoctor().getName()).isEqualToIgnoringCase("黄老邪");
    }

    @Test
    public void givenRegistrationRepositoryWhenFindDateBetween() throws Exception {
        this.localDateTime1.minusDays(1);
        this.localDateTime1.minusDays(-1);
        List<RegistrationEntity> list = this.repository.findByBookDateBetween(this.localDateTime1.minusDays(1), this.localDateTime1.minusDays(-1));
        assertThat(list.size()).isEqualTo(3);
    }
}
