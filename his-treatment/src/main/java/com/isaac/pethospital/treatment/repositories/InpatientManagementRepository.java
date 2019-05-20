package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.InpatientManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InpatientManagementRepository extends JpaRepository<InpatientManagementEntity, Long>
{
    List<InpatientManagementEntity> findByManagementStatus(String status);

}
