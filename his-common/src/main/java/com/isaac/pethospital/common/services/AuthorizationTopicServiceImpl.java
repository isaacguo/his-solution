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
}
