package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.PersistenceConfig;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementPurchaseEntity;
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

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = PersistenceConfig.class)
public class ProcurementPurchaseRepositorySpecTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ProcurementPurchaseRepository repository;

    @Before
    public void init() {


    }


    @Test
    public void findByAssignTo() throws Exception {

        ProcurementEntity procurementEntity=new ProcurementEntity();
        ProcurementPurchaseEntity procurementPurchaseEntity=new ProcurementPurchaseEntity();
        procurementPurchaseEntity.setAssignTo("Isaac");
        procurementEntity.setProcurementPurchase(procurementPurchaseEntity);

        entityManager.persist(procurementPurchaseEntity);
        entityManager.persist(procurementEntity);
        //when
        List<ProcurementPurchaseEntity> list= this.repository.findByAssignTo("Isaac");
        //then
        assertThat(list).hasSize(1);
    }
}
