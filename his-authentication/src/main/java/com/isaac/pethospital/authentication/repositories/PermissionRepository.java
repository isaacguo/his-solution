package com.isaac.pethospital.authentication.repositories;

import com.isaac.pethospital.authentication.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

}
