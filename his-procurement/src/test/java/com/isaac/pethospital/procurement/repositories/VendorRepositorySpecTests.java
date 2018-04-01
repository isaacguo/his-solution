package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.VendorEntity;
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
public class VendorRepositorySpecTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VendorRepository repository;


    @Before
    public void init() {
    }

    @Test
    public void givenTitleWhenFindByTitleThenReturnVendorEntity() throws Exception {
        //given
        VendorEntity authorizationTopicEntity = new VendorEntity();
        authorizationTopicEntity.setName("Company1");
        this.entityManager.persist(authorizationTopicEntity);
        //when
        VendorEntity authorizationTopicEntity1 = this.repository.findByName("Company1");
        //then
        assertThat(authorizationTopicEntity1.getName()).isEqualToIgnoringCase("Company1");
    }

    @Test
    public void givenKeywordWhenFindByNameContainsKeyswordShouldReturnAListOfEntity() {
        //given
        VendorEntity authorizationTopicEntity1 = new VendorEntity();
        authorizationTopicEntity1.setName("Company1");
        this.entityManager.persist(authorizationTopicEntity1);
        VendorEntity authorizationTopicEntity2 = new VendorEntity();
        authorizationTopicEntity2.setName("Company2");
        this.entityManager.persist(authorizationTopicEntity2);

        //when
        List<VendorEntity> list = this.repository.findByNameContainsIgnoreCase("com");
        //then
        assertThat(list).hasSize(2);
    }
}
