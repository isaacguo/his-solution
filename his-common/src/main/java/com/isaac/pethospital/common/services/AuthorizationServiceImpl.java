package com.isaac.pethospital.common.services;

import com.isaac.pethospital.common.entities.AuthorizationEntity;
import com.isaac.pethospital.common.repositories.AuthorizationRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    private final AuthorizationRepository authorizationRepository;


    public AuthorizationServiceImpl(AuthorizationRepository authorizationRepository) {
        this.authorizationRepository = authorizationRepository;
    }


    @Override
    public List<AuthorizationEntity> findAll() {
        return this.authorizationRepository.findAll();
    }

    @Override
    public boolean createAuthorization(AuthorizationEntity request) {

        String username = request.getUsername();
        if (this.authorizationRepository.findByUsername(username) != null)
            throw new RuntimeException("User " + username + "has already exsited.");

        this.authorizationRepository.save(request);
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

        if(StringUtils.isEmpty(any.getUsername()))
            throw new RuntimeException("Username is empty.");
        return this.authorizationRepository.findByUsername(any.getUsername());

    }
}
