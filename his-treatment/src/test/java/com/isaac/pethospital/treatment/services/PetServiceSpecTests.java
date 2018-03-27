package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.PetOperationRequest;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.repositories.PetRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class PetServiceSpecTests {

    PetService petService;
    PetRepository petRepository;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        petRepository = mock(PetRepository.class);
        petService = spy(new PetServiceImpl(petRepository));
    }

    @Test
    public void givenRequestWhenFindPetOwnerThenThrowRuntimeExceptionIfNotExist() {

        //given
        PetOperationRequest petOperationRequest = new PetOperationRequest();
        petOperationRequest.setId(1L);

        doReturn(null).when(petRepository).findOne(petOperationRequest.getId());
        //exception
        exception.expect(RuntimeException.class);
        exception.expectMessage("Pet doesn't exist");
        //when
        this.petService.findPetOwnerByPet(petOperationRequest);
    }

    @Test
    public void givenRequestWhenFindPetOwnerThenFindPet() {

        //given
        PetOperationRequest petOperationRequest = new PetOperationRequest();
        petOperationRequest.setId(1L);
        PetEntity petEntity = new PetEntity();
        petEntity.setId(1L);

        doReturn(petEntity).when(petRepository).findOne(petOperationRequest.getId());
        //when
        this.petService.findPetOwnerByPet(petOperationRequest);
        //then
        verify(petRepository, times(1)).findOne(1L);
    }

    @Test
    public void whenFindNameThenMethodFindByNameInRepositoryIsInvokedOnce() {
        PetEntity petEntity = getPetEntity();
        List<PetEntity> list = new LinkedList<>();
        list.add(petEntity);
        //given
        doReturn(list).when(petRepository).findByName("笨笨");
        //when
        this.petService.findByName("笨笨");
        //then
        verify(petRepository, times(1)).findByName("笨笨");
    }

    private PetEntity getPetEntity() {
        PetEntity petEntity = new PetEntity();
        petEntity.setName("笨笨");
        return petEntity;
    }
}
