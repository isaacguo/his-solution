package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.PersistenceConfig;
import com.isaac.pethospital.procurement.entities.ProcurementConfigurationEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = PersistenceConfig.class)
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
        ProcurementConfigurationEntity pce = new ProcurementConfigurationEntity();
        pce.setConfKey("OrderNumber");
        pce.setConfValue("0");
        entityManager.persist(pce);

        //when
        ProcurementConfigurationEntity res = this.repository.findByConfKey("OrderNumber");
        //then
        assertThat(res.getConfValue()).isEqualToIgnoringCase("0");


    }
}
