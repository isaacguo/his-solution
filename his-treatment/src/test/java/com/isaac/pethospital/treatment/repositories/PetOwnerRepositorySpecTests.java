package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PetOwnerRepositorySpecTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PetOwnerRepository repository;

    @Test
    public void givenPetOwnerRepositoryWhenFindByNameReturnList() throws Exception {
        PetOwnerEntity petOwner = getPetOwnerEntity();
        this.entityManager.persist(petOwner);
        List<PetOwnerEntity> owners = this.repository.findByName("刘备");
        assertThat(owners.size()).isEqualTo(1);
    }

    @Test
    public void givenPetOwnerRepositoryWhenFindByNameReturnPetOwner() throws Exception {
        PetOwnerEntity petOwner = getPetOwnerEntity();
        this.entityManager.persist(petOwner);
        List<PetOwnerEntity> owners = this.repository.findByName("刘备");
        assertThat(owners.get(0).getName()).isEqualTo("刘备");
    }

    @Test
    public void givenPetOwnerRepositoryWhenFindByMemberNumberReturnPetOwner() throws Exception {
        PetOwnerEntity petOwner = getPetOwnerEntity();
        this.entityManager.persist(petOwner);
        PetOwnerEntity owner = this.repository.findByMemberNumber("1122");
        assertThat(owner.getMemberNumber()).isEqualTo("1122");
    }

    private PetOwnerEntity getPetOwnerEntity() {
        PetOwnerEntity petOwner=new PetOwnerEntity();
        petOwner.setName("刘备");
        petOwner.setMemberNumber("1122");
        return petOwner;
    }
}
