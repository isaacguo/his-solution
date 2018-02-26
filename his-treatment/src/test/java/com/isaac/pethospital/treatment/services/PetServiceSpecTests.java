package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.repositories.PetRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class PetServiceSpecTests {

    PetService petService;
    PetRepository petRepository;

    @Before
    public void before() {
        petRepository = mock(PetRepository.class);
        petService = spy(new PetServiceImpl(petRepository));
    }

    @Test
    public void whenFindNameThenMethodFindByNameInRepositoryIsInvokedOnce() {
        PetEntity petEntity = getPetEntity();
        List<PetEntity> list=new LinkedList<>();
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
