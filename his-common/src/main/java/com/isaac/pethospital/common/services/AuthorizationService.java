package com.isaac.pethospital.common.services;

import com.isaac.pethospital.common.entities.AuthorizationEntity;

import java.util.List;

public interface AuthorizationService {
    List<AuthorizationEntity> findAll();

    boolean createAuthorization(AuthorizationEntity any);

    boolean deleteAuthorization(AuthorizationEntity request);

    AuthorizationEntity findByUsername(AuthorizationEntity any);
}
