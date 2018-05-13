package com.isaac.pethospital.common.services;

import com.isaac.pethospital.common.entities.AuthorizationTopicEntity;
import com.isaac.pethospital.common.repositories.AuthorizationTopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationTopicServiceImpl implements AuthorizationTopicService {

    private final AuthorizationTopicRepository authorizationTopicRepository;

    public AuthorizationTopicServiceImpl(AuthorizationTopicRepository authorizationTopicRepository) {
        this.authorizationTopicRepository = authorizationTopicRepository;
    }

    @Override
    public List<AuthorizationTopicEntity> findAll() {
        return authorizationTopicRepository.findAll();
    }

    @Override
    public void addAuthorizationTopicAndOperations(String topic, String... operations) {
        AuthorizationTopicEntity topic1 = new AuthorizationTopicEntity();
        topic1.setName(topic);
        for (int i = 0; i < operations.length; i++) {
            topic1.addAvailableTopicOperationByName(operations[i]);
        }
        authorizationTopicRepository.save(topic1);
    }


    @Override
    public void deleteAll() {
        this.authorizationTopicRepository.deleteAll();

    }
}
