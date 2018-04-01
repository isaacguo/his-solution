package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementApprovalEntity;
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

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ImportAutoConfiguration({RibbonAutoConfiguration.class, FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class})
public class ProcurementApprovalRepositorySpecTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ProcurementApprovalRepository repository;

    @Before
    public void init() {

    }

    @Test
    public void whenFindByKeyThenReturnApprovalEntity() throws Exception {
        //given
        ProcurementApprovalEntity p1 = new ProcurementApprovalEntity();
        p1.setReviewed(false);
        p1.setReviewer("Isaac");

        ProcurementApprovalEntity p3 = new ProcurementApprovalEntity();
        p3.setReviewed(true);
        p3.setReviewer("Isaac");

        ProcurementApprovalEntity p2 = new ProcurementApprovalEntity();
        p2.setReviewed(false);
        p2.setReviewer("David");

        this.entityManager.persist(p1);
        this.entityManager.persist(p2);
        this.entityManager.persist(p3);


        //when
        List<ProcurementApprovalEntity> res = this.repository.findByReviewerAndReviewedIsFalse("Isaac");
        //then
        assertThat(res.size()).isEqualTo(1);


    }
}
