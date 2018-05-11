package com.isaac.pethospital.authentication.repositories;

import com.isaac.pethospital.authentication.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
