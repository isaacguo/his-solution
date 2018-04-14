package com.isaac.pethospital.common.services;

import com.isaac.pethospital.common.dtos.AuthorizationAssignmentOperationRequest;
import com.isaac.pethospital.common.dtos.AuthorizationOperationRequest;
import com.isaac.pethospital.common.entities.AuthorizationAssignmentEntity;
import com.isaac.pethospital.common.entities.AuthorizationEntity;
import com.isaac.pethospital.common.entities.AuthorizationTopicEntity;
import com.isaac.pethospital.common.entities.TopicOperationEntity;
import com.isaac.pethospital.common.repositories.AuthorizationAssignmentRepository;
import com.isaac.pethospital.common.repositories.AuthorizationRepository;
import com.isaac.pethospital.common.repositories.AuthorizationTopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    private final AuthorizationRepository authorizationRepository;
    private final AuthorizationTopicRepository authorizationTopicRepository;
    private final AuthorizationAssignmentRepository authorizationAssignmentRepository;

    public AuthorizationServiceImpl(AuthorizationRepository authorizationRepository, AuthorizationTopicRepository authorizationTopicRepository, AuthorizationAssignmentRepository authorizationAssignmentRepository) {
        this.authorizationRepository = authorizationRepository;
        this.authorizationTopicRepository = authorizationTopicRepository;
        this.authorizationAssignmentRepository = authorizationAssignmentRepository;
    }

    @Override
    public List<AuthorizationEntity> findAll() {
        return this.authorizationRepository.findAll();
    }

    @Override
    public boolean createAuthorization(AuthorizationOperationRequest request) {

        String userAccount = request.getUserAccount();
        if (this.authorizationRepository.findByUserAccount(userAccount) != null)
            throw new RuntimeException("User " + userAccount + "has already exsited.");
        AuthorizationEntity ae = request.toAuthorizationEntity();
        this.authorizationTopicRepository.findAll().forEach(r -> {
            AuthorizationAssignmentEntity aae = new AuthorizationAssignmentEntity();
            aae.setTopic(r);
            ae.addAuthorizationAssignment(aae);
        });


        this.authorizationRepository.save(ae);
        return true;

    }

    @Override
    public boolean deleteAuthorization(AuthorizationEntity request) {
        if (this.authorizationRepository.exists(request.getId()))
            this.authorizationRepository.delete(request.getId());
        return true;
    }

    @Override
    public AuthorizationEntity findByUsername(AuthorizationEntity any) {

        if (StringUtils.isEmpty(any.getUsername()))
            throw new RuntimeException("Username is empty.");
        return this.authorizationRepository.findByUsername(any.getUsername());

    }

    @Override
    public boolean deleteById(Long authorizationId) {

        AuthorizationEntity ae = this.authorizationRepository.findOne(authorizationId);

        ae.getAuthorizationAssignmentList().forEach(r -> {
            int size = r.getAllowedOperations().size();
            for (int i = 0; i < size; i++)
                r.removeAllowedOperation(r.getAllowedOperations().get(0));
        });
        int size = ae.getAuthorizationAssignmentList().size();
        for (int i = 0; i < size; i++) {
            AuthorizationAssignmentEntity aae = ae.getAuthorizationAssignmentList().get(0);
            ae.removeAuthorizationAssignment(aae);
        }

        this.authorizationRepository.delete(ae);
        return true;
    }

    @Override
    public boolean updateAuthorization(AuthorizationOperationRequest request) {
        AuthorizationEntity ae = this.authorizationRepository.findOne(request.getId());
        if (ae == null)
            throw new RuntimeException("Cannot find Authorization");

        ae.getAuthorizationAssignmentList().forEach(authorizationAssignment -> {

            AuthorizationAssignmentOperationRequest aaor = request.getAuthorizationAssignmentList().stream().filter(req -> req.getTopicId() == authorizationAssignment.getTopic().getId()).findFirst().orElse(null);
            //aaor.getAllowedOperationIds().stream().filter(c->)
            if (aaor == null) return;

            List<Long> leftAll = authorizationAssignment.getAllowedOperations().stream().map(op -> op.getId()).collect(Collectors.toList());
            List<TopicOperationEntity> right = aaor.getAllowedOperationIds().stream().filter(id -> !leftAll.contains(id))
                    .map(m -> authorizationAssignment.getTopic().getAvailableTopicOperationList().stream().filter(a -> a.getId() == m).findFirst().orElse(null)).collect(Collectors.toList());
            List<TopicOperationEntity> left = authorizationAssignment.getAllowedOperations().stream().filter(op -> !aaor.getAllowedOperationIds().contains(op.getId())).collect(Collectors.toList());

            left.forEach(l -> authorizationAssignment.removeAllowedOperation(l));
            right.forEach(r -> authorizationAssignment.addAllowedOperation(r));

        });

        /*
        List<Long> idSet = request.getAuthorizationAssignmentList().stream().filter(c -> c.getId() != null).map(m -> m.getId()).collect(Collectors.toList());
        List<AuthorizationAssignmentEntity> interaction = ae.getAuthorizationAssignmentList().stream().filter(r -> idSet.contains(r.getId())).collect(Collectors.toList());
        */


        this.authorizationRepository.save(ae);

        return true;

    }

    @Override
    public boolean isAuthorized(String userAccount, Long tid, Long oid) {

        AuthorizationEntity ae = this.authorizationRepository.findByUserAccount(userAccount);
        if (ae == null)
            throw new RuntimeException("Cannot find Authorization.");

        AuthorizationAssignmentEntity aae = ae.getAuthorizationAssignmentList().stream().filter(t -> t.getTopic().getId() == tid).findFirst().orElse(null);
        if(aae==null)
            throw new RuntimeException("Authorization Assignment is Null.");
        AuthorizationTopicEntity topic = aae.getTopic();
        if (topic == null)
            throw new RuntimeException("Topic is null");

        TopicOperationEntity toe= aae.getAllowedOperations().stream().filter(o->o.getId()==oid).findFirst().orElse(null);

        if (toe == null)
            return false;
        else
            return true;
    }

    /*
    private void notAGoodImplementation(AuthorizationOperationRequest request, AuthorizationEntity ae) {
        int size = ae.getAuthorizationAssignmentList().size();
        for (int i = 0; i < size; i++) {
            AuthorizationAssignmentEntity aae = ae.getAuthorizationAssignmentList().get(0);
            ae.removeAuthorizationAssignment(aae);
        }


        request.getAuthorizationAssignmentList().forEach(r -> {

            AuthorizationAssignmentEntity authorizationAssignmentEntity = new AuthorizationAssignmentEntity();
            AuthorizationTopicEntity topic = this.authorizationTopicRepository.findOne(r.getTopicId());
            authorizationAssignmentEntity.setTopic(topic);

            r.getAllowedOperationIds().forEach(op -> {
                TopicOperationEntity toe = topic.getAvailableTopicOperationList().stream().filter(aop -> aop.getId() == op).findFirst().orElse(null);
                if (toe == null)
                    throw new RuntimeException("Cannot find Topic Operation, maybe hacked.");
                authorizationAssignmentEntity.addAllowedOperation(toe);
            });

            this.authorizationAssignmentRepository.save(authorizationAssignmentEntity);

            ae.addAuthorizationAssignment(authorizationAssignmentEntity);

        });
    }
    */
}
