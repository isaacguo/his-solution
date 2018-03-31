package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementConfigurationEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProcurementConfigurationRepositorySpecTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ProcurementConfigurationRepository repository;

    @Before
    public void init() {


    }

    @Test
    public void whenFindByKeyThenReturnConfigurationEntity() throws Exception {
        /*
        ProcurementConfigurationEntity pce = new ProcurementConfigurationEntity();
        pce.setKey("OrderNumber");
        pce.setValue("0");
        entityManager.persist(pce);
        */

        //when
        ProcurementConfigurationEntity res = this.repository.findByKey("OrderNumber");
        //then
        assertThat(res.getValue()).isEqualToIgnoringCase("1");


    }
}
