package com.isaac.pethospital.treatment.services;


import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import com.isaac.pethospital.treatment.repositories.PetOwnerRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PetOwnerServiceSpecTests {

    PetOwnerService petOwnerService;
    PetOwnerRepository petOwnerRepository;

    @Before
    public void before() {
        petOwnerRepository = mock(PetOwnerRepository.class);
        petOwnerService = spy(new PetOwnerServiceImpl(petOwnerRepository));
    }

    @Test
    public void whenCreateNewPetOwnerThenCreated()
    {
        //given
        PetOwnerEntity petOwnerEntity = getPetOwnerEntity();
        //when
        this.petOwnerService.createOwner(petOwnerEntity);
        //then
         verify(petOwnerRepository, times(1)).save(petOwnerEntity);
    }

    @Test
    public void whenFindByMemberNumberThenMethodFindByMemberNumberInRepositoryIsInvokedOnce() {
        PetOwnerEntity petOwnerEntity = getPetOwnerEntity();
        //given
        doReturn(petOwnerEntity).when(petOwnerRepository).findByMemberNumber("123");
        //when
        this.petOwnerService.findByMemberNumber("123");
        //then
        verify(petOwnerRepository, times(1)).findByMemberNumber("123");
    }

    @Test
    public void whenFindNameThenMethodFindByNameInRepositoryIsInvokedOnce() {
        PetOwnerEntity petOwnerEntity = getPetOwnerEntity();
        List<PetOwnerEntity> list=new LinkedList<>();
        list.add(petOwnerEntity);
        //given
        doReturn(list).when(petOwnerRepository).findByName("刘备");
        //when
        this.petOwnerService.findByName("刘备");
        //then
        verify(petOwnerRepository, times(1)).findByName("刘备");
    }

    private PetOwnerEntity getPetOwnerEntity() {
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setMemberNumber("123");
        petOwnerEntity.setName("刘备");
        return petOwnerEntity;
    }


}
