package com.isaac.pethospital.common.converter.services;

import com.isaac.pethospital.common.entities.AuthorizationEntity;
import com.isaac.pethospital.common.repositories.AuthorizationRepository;
import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.common.services.AuthorizationServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AuthorizationServiceSpecTests {

    AuthorizationRepository authorizationRepository;
    AuthorizationService authorizationService;

    @Before
    public void before() {
        this.authorizationRepository = mock(AuthorizationRepository.class);
        this.authorizationService = spy(new AuthorizationServiceImpl(this.authorizationRepository));
    }

    @Test
    public void givenAuthorizationOperationRequestThenCreateAuthorizationEntity() {
        //given
        //AuthorizationOperationRequest authorizationOperationRequest = new AuthorizationOperationRequest();

        //authorizationOperationRequest.setName("Company");
        AuthorizationEntity authorizationEntity = new AuthorizationEntity();
        authorizationEntity.setUsername("Isaac");
        doReturn(null).when(authorizationRepository).findByUsername(any(String.class));
        //when
        this.authorizationService.createAuthorization(authorizationEntity);
        //then
        verify(authorizationRepository, times(1)).findByUsername(any(String.class));
        verify(authorizationRepository, times(1)).save(any(AuthorizationEntity.class));
    }

    @Test
    public void givenAuthorizationOperationRequestThenDeleteAuthorizationEntity() {
        //given
        AuthorizationEntity authorizationEntity = new AuthorizationEntity();
        authorizationEntity.setUsername("Isaac");
        authorizationEntity.setId(1L);
        doReturn(true).when(authorizationRepository).exists(any(Long.class));
        //when
        this.authorizationService.deleteAuthorization(authorizationEntity);
        //then
        verify(authorizationRepository, times(1)).exists(1L);
        verify(authorizationRepository, times(1)).delete(1L);
    }

    @Test
    public void givenAuthorizationOperationRequestThenFindAuthorizationEntityByName() {
        //given
        //AuthorizationOperationRequest authorizationOperationRequest = new AuthorizationOperationRequest();
        //authorizationOperationRequest.setName("Company");
        //doReturn(new AuthorizationEntity()).when(authorizationRepository).findByName("Company");
        AuthorizationEntity authorizationEntity=new AuthorizationEntity();
        authorizationEntity.setUsername("Isaac");
        //when
        this.authorizationService.findByUsername(authorizationEntity);
        //then
        verify(authorizationRepository, times(1)).findByUsername("Isaac");
    }


    /*
    @Test
    public void givenKeywordStringWhenFindByNameContainsKeywordThenReturnList() {
        //given
        String keyword = "com";
        doReturn(new LinkedList<AuthorizationEntity>()).when(authorizationRepository).findByNameContainsIgnoreCase("com");
        //when
        this.authorizationService.findByNameContains(keyword);
        //then
        verify(authorizationRepository, times(1)).findByNameContainsIgnoreCase("com");
    }
    */
}
