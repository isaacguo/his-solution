package com.isaac.pethospital.finance.repositories;

import com.isaac.pethospital.finance.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    List<PriceEntity> findByChargeItemUuidIn(List<String> uuids);

    PriceEntity findByChargeItemUuid(String uuid);

}
