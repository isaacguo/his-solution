package com.isaac.pethospital.common.repositories;

import com.isaac.pethospital.common.entities.CommonConfigurationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonConfigurationRepository extends JpaRepository<CommonConfigurationEntity,Long> {

    CommonConfigurationEntity findByConfKey(String confKey);

}
