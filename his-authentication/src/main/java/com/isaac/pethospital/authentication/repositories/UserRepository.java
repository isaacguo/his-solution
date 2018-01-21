package com.isaac.pethospital.authentication.repositories;

import com.isaac.pethospital.authentication.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
