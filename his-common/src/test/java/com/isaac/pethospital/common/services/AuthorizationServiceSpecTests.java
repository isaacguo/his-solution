package com.isaac.pethospital.common.converter.services;

import com.isaac.pethospital.common.dtos.AuthorizationAssignmentOperationRequest;
import com.isaac.pethospital.common.dtos.AuthorizationOperationRequest;
import com.isaac.pethospital.common.entities.AuthorizationAssignmentEntity;
import com.isaac.pethospital.common.entities.AuthorizationEntity;
import com.isaac.pethospital.common.entities.AuthorizationTopicEntity;
import com.isaac.pethospital.common.entities.TopicOperationEntity;
import com.isaac.pethospital.common.repositories.AuthorizationAssignmentRepository;
import com.isaac.pethospital.common.repositories.AuthorizationRepository;
import com.isaac.pethospital.common.repositories.AuthorizationTopicRepository;
import com.isaac.pethospital.common.repositories.CommonConfigurationRepository;
import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.common.services.AuthorizationServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AuthorizationServiceSpecTests {

    AuthorizationRepository authorizationRepository;
    AuthorizationTopicRepository authorizationTopicRepository;
    AuthorizationAssignmentRepository authorizationAssignmentRepository;
    AuthorizationService authorizationService;
    CommonConfigurationRepository commonConfigurationRepository;


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        this.authorizationRepository = mock(AuthorizationRepository.class);
        this.authorizationTopicRepository = mock(AuthorizationTopicRepository.class);
        this.authorizationAssignmentRepository = mock(AuthorizationAssignmentRepository.class);
        this.commonConfigurationRepository=mock(CommonConfigurationRepository.class);
        this.authorizationService = spy(new AuthorizationServiceImpl(this.authorizationRepository, this.authorizationTopicRepository,
                this.authorizationAssignmentRepository,this.commonConfigurationRepository));
    }

    @Test
    public void givenAuthorizationOperationRequestThenCreateAuthorizationEntity() {
        //given
        //AuthorizationOperationRequest authorizationOperationRequest = new AuthorizationOperationRequest();

        //authorizationOperationRequest.setName("Company");
        AuthorizationOperationRequest request = new AuthorizationOperationRequest();
        request.setUid(1L);
        request.setUsername("renwoxing");
        request.setUserAccount("renwoxing");
        doReturn(null).when(authorizationRepository).findByUsername(any(String.class));
        //when
        this.authorizationService.createAuthorization(request);
        //then
        verify(authorizationRepository, times(1)).findByUserAccount(any(String.class));
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
    public void givenIdWhenDeleteByIdThenDeleteIt() {

        doReturn(new AuthorizationEntity()).when(this.authorizationRepository).findOne(any(Long.class));
        //when
        this.authorizationService.deleteById(1L);
        //then
        verify(this.authorizationRepository, times(1)).delete(any(AuthorizationEntity.class));


    }

    @Test
    public void givenAuthorizationOperationRequestThenFindAuthorizationEntityByName() {
        //given
        //AuthorizationOperationRequest authorizationOperationRequest = new AuthorizationOperationRequest();
        //authorizationOperationRequest.setName("Company");
        //doReturn(new AuthorizationEntity()).when(authorizationRepository).findByName("Company");
        AuthorizationEntity authorizationEntity = new AuthorizationEntity();
        authorizationEntity.setUsername("Isaac");
        //when
        this.authorizationService.findByUsername(authorizationEntity);
        //then
        verify(authorizationRepository, times(1)).findByUsername("Isaac");
    }

    @Test
    public void whenUpdateAuthorizationThenFindAuthorizationEntityFirst() {
        //given
        AuthorizationOperationRequest request = initForUpdateAuthorization();
        //when
        this.authorizationService.updateAuthorization(request);
        //then
        verify(authorizationRepository, times(1)).findOne(1L);

    }


    private AuthorizationOperationRequest initForUpdateAuthorization() {
        AuthorizationOperationRequest request = new AuthorizationOperationRequest();
        request.setId(1L);
        List<AuthorizationAssignmentOperationRequest> aaor = new LinkedList<>();
        AuthorizationAssignmentOperationRequest request1 = new AuthorizationAssignmentOperationRequest();
        doReturn(new AuthorizationEntity()).when(this.authorizationRepository).findOne(1L);
        request1.setTopicId(1L);
        request.setAuthorizationAssignmentList(aaor);
        return request;
    }


    @Test
    public void whenIsAuthorizedInvokedThenGetTopic() {

        AuthorizationEntity authorizationEntity=new AuthorizationEntity();
        AuthorizationAssignmentEntity aae=new AuthorizationAssignmentEntity();
        AuthorizationTopicEntity topicEntity=new AuthorizationTopicEntity();
        topicEntity.setId(1L);
        topicEntity.setName("ABC");
        TopicOperationEntity toe=new TopicOperationEntity();
        toe.setId(2L);
        toe.setName("BCD");

        aae.setTopic(topicEntity);
        aae.addAllowedOperation(toe);
        authorizationEntity.addAuthorizationAssignment(aae);
        authorizationEntity.setUserAccount("Isaac");
        doReturn(authorizationEntity).when(this.authorizationRepository).findByUserAccount("Isaac");

        //when
        this.authorizationService.isAuthorized("Isaac", "ABC", "BCD");
        //then
        verify(this.authorizationRepository, times(1)).findByUserAccount("Isaac");
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
