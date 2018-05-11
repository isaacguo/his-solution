package com.isaac.pethospital.common.repositories;

import com.isaac.pethospital.common.entities.AuthorizationAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationAssignmentRepository extends JpaRepository<AuthorizationAssignmentEntity,Long> {
}
