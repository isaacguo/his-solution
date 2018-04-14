package com.isaac.pethospital.common.services;

import com.isaac.pethospital.common.dtos.AuthorizationOperationRequest;
import com.isaac.pethospital.common.entities.AuthorizationEntity;

import java.util.List;

public interface AuthorizationService {
    List<AuthorizationEntity> findAll();

    boolean createAuthorization(AuthorizationOperationRequest request);

    boolean deleteAuthorization(AuthorizationEntity request);

    AuthorizationEntity findByUsername(AuthorizationEntity any);

    boolean deleteById(Long authorizationId);

    boolean updateAuthorization(AuthorizationOperationRequest request);

    boolean isAuthorized(String userAccount, Long tid, Long oid);
}
