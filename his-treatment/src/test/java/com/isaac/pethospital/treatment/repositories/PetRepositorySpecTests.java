package com.isaac.pethospital.treatment.repositories;

import static org.assertj.core.api.Java6Assertions.assertThat;

import com.isaac.pethospital.treatment.entities.PetEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PetRepositorySpecTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PetRepository repository;

    @Test
    public void givenPetRepositoryWhenFindByNameReturnList() throws Exception {
        PetEntity petOwner = getPetEntity();
        this.entityManager.persist(petOwner);
        List<PetEntity> owners = this.repository.findByName("宠物1");
        assertThat(owners.size()).isEqualTo(1);
    }

    @Test
    public void givenPetRepositoryWhenFindByNameReturnPetOwner() throws Exception {
        PetEntity petOwner = getPetEntity();
        this.entityManager.persist(petOwner);
        List<PetEntity> owners = this.repository.findByName("宠物1");
        assertThat(owners.get(0).getName()).isEqualTo("宠物1");
    }

    private PetEntity getPetEntity() {
        PetEntity petOwner=new PetEntity();
        petOwner.setName("宠物1");
        return petOwner;
    }
}
