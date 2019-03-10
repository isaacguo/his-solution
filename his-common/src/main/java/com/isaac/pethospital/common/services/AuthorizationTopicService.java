package com.isaac.pethospital.common.services;


import com.isaac.pethospital.common.entities.AuthorizationTopicEntity;

import java.util.List;

public interface AuthorizationTopicService {
    List<AuthorizationTopicEntity> findAll();
    void addAuthorizationTopicAndOperations(String topic, String... operations);
    void deleteAll();
}
