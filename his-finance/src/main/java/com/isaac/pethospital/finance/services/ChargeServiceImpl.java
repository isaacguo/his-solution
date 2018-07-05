package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.common.dtos.ChargeItemOperationMesassge;
import com.isaac.pethospital.finance.entities.ChargeEntity;
import com.isaac.pethospital.finance.repositories.ChargeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {

    private final ChargeRepository chargeRepository;

    public ChargeServiceImpl(ChargeRepository chargeRepository) {
        this.chargeRepository = chargeRepository;
    }

    @Override
    public void onChargeItemEventReceived(ChargeItemOperationMesassge mesassge) {

        switch (mesassge.getOperationEnum()) {

            case CREATE:
                ChargeEntity chargeEntity = new ChargeEntity();
                chargeEntity.setChargeItemUuid(mesassge.getUuid());
                chargeEntity.setFromService(mesassge.getSource());
                this.chargeRepository.save(chargeEntity);
                break;
        }

    }

    @Override
    public List<ChargeEntity> findAll() {
        return this.chargeRepository.findAll();
    }
}
