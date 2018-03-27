package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.VendorEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
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
        VendorEntity authorizationTopicEntity=new VendorEntity();
        authorizationTopicEntity.setName("Company1");
        this.entityManager.persist(authorizationTopicEntity);
        //when
        VendorEntity authorizationTopicEntity1 = this.repository.findByName("Company1");
        //then
        assertThat(authorizationTopicEntity1.getName()).isEqualToIgnoringCase("Company1");
    }
}
