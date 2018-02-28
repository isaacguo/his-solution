package com.isaac.pethospital.treatment.services;


import com.isaac.pethospital.treatment.dtos.PetOwnerAddPetRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerCreateRequest;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import com.isaac.pethospital.treatment.repositories.PetOwnerRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PetOwnerServiceSpecTests {

    PetOwnerService petOwnerService;
    PetOwnerRepository petOwnerRepository;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        petOwnerRepository = mock(PetOwnerRepository.class);
        petOwnerService = spy(new PetOwnerServiceImpl(petOwnerRepository));
    }

    @Test
    public void whenCreateNewPetOwnerThenCreated() {
        //given
        PetOwnerCreateRequest petOwnerCreateRequest = new PetOwnerCreateRequest();
        //when
        this.petOwnerService.createPetOwner(petOwnerCreateRequest);
        //then
        verify(petOwnerRepository, times(1)).save(any(PetOwnerEntity.class));
    }

    @Test
    public void whenAddNewPetThenThrowExceptionIfOwnerIsNotFound() {
        //given
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setId(2L);
        PetOwnerAddPetRequest petOwnerAddPetRequest = new PetOwnerAddPetRequest();
        petOwnerAddPetRequest.setPetOwner(petOwnerEntity);
        doReturn(false).when(this.petOwnerRepository).exists(1L);
        //expected
        exception.expect(RuntimeException.class);
        exception.expectMessage("Cannot find Pet Owner");
        //when
        this.petOwnerService.addPet(petOwnerAddPetRequest);
    }

    @Test
    public void whenAddNewPetThenSavePetOwner() {
        //given
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setId(1L);
        PetOwnerAddPetRequest petOwnerAddPetRequest = new PetOwnerAddPetRequest();
        petOwnerAddPetRequest.setPetOwner(petOwnerEntity);
        doReturn(true).when(petOwnerRepository).exists(1L);
        doReturn(petOwnerEntity).when(petOwnerRepository).getOne(1L);
        //when
        this.petOwnerService.addPet(petOwnerAddPetRequest);
        //then
        verify(petOwnerRepository, times(1)).save(any(PetOwnerEntity.class));
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
        List<PetOwnerEntity> list = new LinkedList<>();
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
