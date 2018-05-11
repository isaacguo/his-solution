package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.common.converter.LocalDateTimeConverter;
import com.isaac.pethospital.procurement.PersistenceConfig;
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
import org.springframework.context.annotation.Import;
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
public class ProcurementRepositorySpecTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ProcurementRepository repository;

    @Before
    public void init() {

    }

    @Test
    public void findMyProcurementByPurchaseByAssignee() throws Exception {
        ProcurementEntity pe = new ProcurementEntity();
        ProcurementPurchaseEntity pre = new ProcurementPurchaseEntity();
        pre.setAssignTo("Isaac");
        pe.setProcurementPurchase(pre);

        entityManager.persist(pe);
        entityManager.persist(pre);

        //when
        List<ProcurementEntity> list = this.repository.findMyProcurementByPurchaseByAssignee("Isaac");
        //then
        assertThat(list).hasSize(1);

    }

    @Test
    public void findByRequesterThenFindSetsByJoiningTwoTables() throws Exception {

        ProcurementEntity procurementEntity = new ProcurementEntity();
        ProcurementRequestEntity procurementRequestEntity = new ProcurementRequestEntity();
        procurementRequestEntity.setRequester("Isaac");
        procurementEntity.setProcurementRequest(procurementRequestEntity);

        entityManager.persist(procurementRequestEntity);
        entityManager.persist(procurementEntity);
        //when
        List<ProcurementEntity> list = this.repository.findByRequester("Isaac");
        //then
        assertThat(list).hasSize(1);
    }

    @Test
    public void findByQuery() throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse("2018-04-01 13:46:58", formatter);
        LocalDateTime endDateTime = LocalDateTime.parse("2018-04-01 13:47:00", formatter);
        LocalDateTime submittedDateTime = LocalDateTime.parse("2018-04-01 13:46:59", formatter);

        ProcurementEntity procurementEntity = new ProcurementEntity();
        ProcurementRequestEntity procurementRequestEntity = new ProcurementRequestEntity();
        procurementRequestEntity.setRequester("Isaac");
        procurementRequestEntity.setSubmittedData(submittedDateTime);
        procurementEntity.setProcurementRequest(procurementRequestEntity);

        entityManager.persist(procurementRequestEntity);
        entityManager.persist(procurementEntity);

        //when
        List<ProcurementEntity> list = this.repository.findByQuery(startDateTime,endDateTime);
        //then
        assertThat(list).hasSize(1);

    }

}
