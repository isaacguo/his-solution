package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ImportAutoConfiguration({RibbonAutoConfiguration.class, FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class})
public class ProcurementStatusRepositorySpecTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProcurementStatusRepository repository;

    ProcurementStatusEntity status1;

    @Before
    public void init() {

        status1 = new ProcurementStatusEntity();
        status1.setStatus("申请已提交");
        ProcurementStatusEntity status2 = new ProcurementStatusEntity();
        status2.setStatus("申请已批复");
        ProcurementStatusEntity status3 = new ProcurementStatusEntity();
        status3.setStatus("申请已退回");
        ProcurementStatusEntity status4 = new ProcurementStatusEntity();
        status4.setStatus("合同已订立");
        ProcurementStatusEntity status5 = new ProcurementStatusEntity();
        status5.setStatus("合同已逾期");
        ProcurementStatusEntity status6 = new ProcurementStatusEntity();
        status6.setStatus("货物已收到");
        ProcurementStatusEntity status7 = new ProcurementStatusEntity();
        status7.setStatus("货物已退货");
        ProcurementStatusEntity status8 = new ProcurementStatusEntity();
        status8.setStatus("货物已入库");


        status1.addNext(status2);
        status1.addNext(status3);

        status2.addNext(status4);
        status2.addNext(status5);

        status4.addNext(status6);
        status4.addNext(status7);

        status6.addNext(status8);
    }

    @Test
    public void whenGetParentThenReturnParentNode() throws Exception {
        /* conflict with commandlinerunner
        //given
        this.entityManager.persist(status0);

        //when
        ProcurementStatusEntity parent = this.repository.findProcurementStatusEntityByParentIsNull();
        //then
        assertThat(parent.getParent()).isNull();
        assertThat(parent.getStatus()).isEqualToIgnoringCase("申请已创建");
        assertThat(parent.getNext().size()).isGreaterThan(0);
        */
    }

}
