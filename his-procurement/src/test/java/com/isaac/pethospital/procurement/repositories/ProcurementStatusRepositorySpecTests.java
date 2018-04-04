package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;
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

@RunWith(SpringRunner.class)
@DataJpaTest
@OverrideAutoConfiguration(enabled = true)
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
        status2.setLastStatusResult(true);
        ProcurementStatusEntity status3 = new ProcurementStatusEntity();
        status3.setStatus("申请已退回");
        status3.setLastStatusResult(false);
        ProcurementStatusEntity status4 = new ProcurementStatusEntity();
        status4.setStatus("合同已订立");
        status4.setLastStatusResult(true);
        ProcurementStatusEntity status5 = new ProcurementStatusEntity();
        status5.setStatus("合同已逾期");
        status5.setLastStatusResult(false);
        ProcurementStatusEntity status6 = new ProcurementStatusEntity();
        status6.setStatus("货物已收到");
        status6.setLastStatusResult(true);
        ProcurementStatusEntity status7 = new ProcurementStatusEntity();
        status7.setStatus("货物已退货");
        status7.setLastStatusResult(false);
        ProcurementStatusEntity status8 = new ProcurementStatusEntity();
        status8.setStatus("货物已入库");
        status8.setLastStatusResult(true);


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
