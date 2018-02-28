package com.isaac.pethospital.treatment.services;


import com.isaac.pethospital.treatment.dtos.PetOwnerPetOperationRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerOperationRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerDeletePetRequest;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import com.isaac.pethospital.treatment.repositories.PetOwnerRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        PetOwnerOperationRequest petOwnerOperationRequest = new PetOwnerOperationRequest();
        //when
        this.petOwnerService.createPetOwner(petOwnerOperationRequest);
        //then
        verify(petOwnerRepository, times(1)).save(any(PetOwnerEntity.class));
    }

    @Test
    public void givenRequestWhenUpdatePetOwnerThenThrowExecptionIfIdIsEmpty() {
        //given
        PetOwnerOperationRequest request = new PetOwnerOperationRequest();
        //expected
        exception.expect(RuntimeException.class);
        exception.expectMessage("Pet Owner Id Should Not Be Zero");
        //when
        this.petOwnerService.updatePetOwner(request);
    }

    @Test
    public void givenRequestWhenUpdatePetOwnerThenThrowExecptionIfOwnerDoesNotExist() {
        //given
        PetOwnerOperationRequest request = new PetOwnerOperationRequest();
        request.setId(1L);
        doReturn(false).when(petOwnerRepository).exists(1L);
        //expected
        exception.expect(RuntimeException.class);
        exception.expectMessage("Pet Owner Cannot Be Found.");
        //when
        this.petOwnerService.updatePetOwner(request);
    }

    @Test
    public void givenRequestWhenUpdatePetOwnerThenSuccess() {
        //given
        PetOwnerOperationRequest request = new PetOwnerOperationRequest();
        request.setId(1L);
        doReturn(true).when(petOwnerRepository).exists(1L);
        doReturn(new PetOwnerEntity()).when(petOwnerRepository).getOne(1L);
        //when
        this.petOwnerService.updatePetOwner(request);
        //then
        verify(petOwnerRepository, times(1)).save(any(PetOwnerEntity.class));
    }

    @Test
    public void whenAddNewPetThenThrowExceptionIfOwnerIsNotFound() {
        //given
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setId(2L);
        PetOwnerPetOperationRequest petOwnerPetOperationRequest = new PetOwnerPetOperationRequest();
        petOwnerPetOperationRequest.setPetOwner(petOwnerEntity);
        doReturn(false).when(this.petOwnerRepository).exists(1L);
        //expected
        exception.expect(RuntimeException.class);
        exception.expectMessage("Cannot find Pet Owner");
        //when
        this.petOwnerService.addPet(petOwnerPetOperationRequest);
    }

    @Test
    public void whenAddNewPetThenSavePetOwner() {
        //given
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setId(1L);
        PetOwnerPetOperationRequest petOwnerPetOperationRequest = new PetOwnerPetOperationRequest();
        petOwnerPetOperationRequest.setPetOwner(petOwnerEntity);
        doReturn(true).when(petOwnerRepository).exists(1L);
        doReturn(petOwnerEntity).when(petOwnerRepository).getOne(1L);
        //when
        this.petOwnerService.addPet(petOwnerPetOperationRequest);
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

    @Test
    public void whenDeletePetByIdThenThrowExceptionIfPetOwnerIsNotFound() {
        //given
        PetOwnerDeletePetRequest request = new PetOwnerDeletePetRequest();
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setId(2L);
        PetEntity petEntity = new PetEntity();
        petEntity.setId(1L);
        petOwnerEntity.addPet(petEntity);
        request.setId(1L);
        request.setPetOwner(petOwnerEntity);
        //expected
        exception.expect(RuntimeException.class);
        exception.expectMessage("Cannot find Pet Owner");
        //when
        this.petOwnerService.deletePet(request);
    }


    @Test
    public void whenDeletePetByIdThenPetIsRemovedOutOfThePetList() {
        //given
        PetOwnerDeletePetRequest request = new PetOwnerDeletePetRequest();
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setId(2L);
        PetEntity petEntity = new PetEntity();
        petEntity.setId(1L);
        petOwnerEntity.addPet(petEntity);
        request.setId(1L);
        request.setPetOwner(petOwnerEntity);
        doReturn(true).when(this.petOwnerRepository).exists(2L);
        doReturn(petOwnerEntity).when(this.petOwnerRepository).getOne(2L);
        //when
        this.petOwnerService.deletePet(request);
        //then
        assertThat(petOwnerEntity.getPetList().size()).isEqualTo(0);
        verify(petOwnerRepository, times(1)).save(any(PetOwnerEntity.class));
    }


    @Test
    public void givenRequestWhenUpdatePetThenThrowExceptionIfIdIsEmpty() {
        //given
        PetOwnerPetOperationRequest request = new PetOwnerPetOperationRequest();
        //expected
        exception.expect(RuntimeException.class);
        exception.expectMessage("Pet Id Should Not Be Zero");
        //when
        this.petOwnerService.updatePet(request);
    }

    @Test
    public void givenRequestWhenUpdatePetThenThrowExceptionIfOwnerIsNull() {
        //given
        PetOwnerPetOperationRequest request = new PetOwnerPetOperationRequest();
        request.setId(1L);

        //expected
        exception.expect(RuntimeException.class);
        exception.expectMessage("Pet Owner Id Should Not Be Zero");
        //when
        this.petOwnerService.updatePet(request);

    }

    @Test
    public void givenRequestWhenUpdatePetThenThrowExceptionIfOwnerDoesNotExistInRepo() {
        //given
        PetOwnerPetOperationRequest request = new PetOwnerPetOperationRequest();
        request.setId(1L);
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setId(2L);
        request.setPetOwner(petOwnerEntity);

        doReturn(false).when(petOwnerRepository).exists(2L);
        //expected
        exception.expect(RuntimeException.class);
        exception.expectMessage("Pet Owner Cannot Be Found.");
        //when
        this.petOwnerService.updatePet(request);
    }

    @Test
    public void givenRequestWhenUpdatePetThenSuccess() {
        //given
        PetOwnerPetOperationRequest request = new PetOwnerPetOperationRequest();
        request.setId(1L);
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setId(2L);

        request.setPetOwner(petOwnerEntity);

        PetEntity petEntity=new PetEntity();
        petEntity.setId(1L);

        petOwnerEntity.addPet(petEntity);

        doReturn(true).when(petOwnerRepository).exists(2L);
        doReturn(petOwnerEntity).when(petOwnerRepository).getOne(2L);
        //when
        this.petOwnerService.updatePet(request);

        verify(petOwnerRepository,times(1)).save(any(PetOwnerEntity.class));
    }

    /*
    @Test
    public void givenRequestWhenUpdatePetOwnerThenSuccess() {
        //given
        PetOwnerOperationRequest request = new PetOwnerOperationRequest();
        request.setId(1L);
        doReturn(true).when(petOwnerRepository).exists(1L);
        doReturn(new PetOwnerEntity()).when(petOwnerRepository).getOne(1L);
        //when
        this.petOwnerService.updatePetOwner(request);
        //then
        verify(petOwnerRepository, times(1)).save(any(PetOwnerEntity.class));
    }
    */


    private PetOwnerEntity getPetOwnerEntity() {
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setMemberNumber("123");
        petOwnerEntity.setName("刘备");
        return petOwnerEntity;
    }

}
