package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
