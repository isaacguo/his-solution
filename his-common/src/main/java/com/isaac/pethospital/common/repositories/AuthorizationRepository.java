package com.isaac.pethospital.common.repositories;

import com.isaac.pethospital.common.entities.AuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationRepository extends JpaRepository<AuthorizationEntity, Long> {
    AuthorizationEntity findByUsername(String userName);
}
