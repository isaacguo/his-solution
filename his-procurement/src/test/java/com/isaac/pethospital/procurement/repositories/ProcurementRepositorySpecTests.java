package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementPurchaseEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;
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
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@OverrideAutoConfiguration(enabled = true)
public class ProcurementRepositorySpecTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ProcurementRepository repository;

    @Before
    public void init() {

    }

    @Test
    public void findMyProcurementByPurchaseByAssignee() throws Exception
    {
        ProcurementEntity pe=new ProcurementEntity();
        ProcurementPurchaseEntity pre=new ProcurementPurchaseEntity();
        pre.setAssignTo("Isaac");
        pe.setProcurementPurchase(pre);

        entityManager.persist(pe);
        entityManager.persist(pre);

        //when
        List<ProcurementEntity> list=this.repository.findMyProcurementByPurchaseByAssignee("Isaac");
        //then
        assertThat(list).hasSize(1);

    }

    @Test
    public void findByRequesterThenFindSetsByJoiningTwoTables() throws Exception {

        ProcurementEntity procurementEntity=new ProcurementEntity();
        ProcurementRequestEntity procurementRequestEntity=new ProcurementRequestEntity();
        procurementRequestEntity.setRequester("Isaac");
        procurementEntity.setProcurementRequest(procurementRequestEntity);

        entityManager.persist(procurementRequestEntity);
        entityManager.persist(procurementEntity);
        //when
        List<ProcurementEntity> list= this.repository.findByRequester("Isaac");
        //then
        assertThat(list).hasSize(1);
    }
}
