package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.PersistenceConfig;
import com.isaac.pethospital.procurement.entities.VendorEntity;
import com.isaac.pethospital.procurement.jms.ProcurementListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = PersistenceConfig.class)
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
