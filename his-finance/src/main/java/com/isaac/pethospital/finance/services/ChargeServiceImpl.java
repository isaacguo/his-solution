package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.common.dtos.ChargeItemOperationMesassge;
import com.isaac.pethospital.finance.dtos.ChargeOperationRequest;
import com.isaac.pethospital.finance.entities.ChargeEntity;
import com.isaac.pethospital.finance.repositories.ChargeRepository;
import org.apache.commons.lang.StringUtils;
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

    @Override
    public ChargeEntity findOne(Long id) {
        return this.chargeRepository.findOne(id);
    }

    @Override
    public List<ChargeEntity> findByUuids(ChargeOperationRequest request) {
        return this.chargeRepository.findByChargeItemUuidIn(request.getUuids());
    }

    @Override
    public ChargeEntity findByUuid(String uuid) {

        ChargeEntity charge = this.chargeRepository.findByChargeItemUuid(uuid);
        if (charge == null)
            return new ChargeEntity();
        else return charge;
    }

    @Override
    public ChargeEntity update(ChargeOperationRequest request) {
        String uuid = request.getUuid();
        if (StringUtils.isEmpty(uuid))
            throw new RuntimeException("Uuid is null");
        ChargeEntity charge = this.chargeRepository.findByChargeItemUuid(uuid);
        if (charge == null) {
            charge = new ChargeEntity();
            charge.setChargeItemUuid(uuid);
        }

        if (request.getNormalPrice() != null && request.getNormalPrice() > 0)
            charge.setNormalPrice(request.getNormalPrice());
        else if (request.getMemberPrice() != null && request.getMemberPrice() > 0)
            charge.setMemberPrice(request.getMemberPrice());

        return chargeRepository.save(charge);
    }

}
