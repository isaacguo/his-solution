package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.common.dtos.ChargeItemOperationMesassge;
import com.isaac.pethospital.finance.dtos.PriceOperationRequest;
import com.isaac.pethospital.finance.entities.PriceEntity;
import com.isaac.pethospital.finance.repositories.PriceRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void onChargeItemEventReceived(ChargeItemOperationMesassge mesassge) {

        switch (mesassge.getOperationEnum()) {

            case CREATE:
                PriceEntity priceEntity = new PriceEntity();
                priceEntity.setChargeItemUuid(mesassge.getUuid());
                priceEntity.setFromService(mesassge.getSource());
                this.priceRepository.save(priceEntity);
                break;
        }

    }

    @Override
    public List<PriceEntity> findAll() {
        return this.priceRepository.findAll();
    }

    @Override
    public PriceEntity findOne(Long id) {
        return this.priceRepository.findOne(id);
    }

    @Override
    public List<PriceEntity> findByUuids(PriceOperationRequest request) {
        return this.priceRepository.findByChargeItemUuidIn(request.getUuids());
    }

    @Override
    public PriceEntity findByUuid(String uuid) {

        PriceEntity charge = this.priceRepository.findByChargeItemUuid(uuid);
        if (charge == null)
            return new PriceEntity();
        else return charge;
    }

    @Override
    public PriceEntity update(PriceOperationRequest request) {
        String uuid = request.getUuid();
        if (StringUtils.isEmpty(uuid))
            throw new RuntimeException("Uuid is null");
        PriceEntity charge = this.priceRepository.findByChargeItemUuid(uuid);
        if (charge == null) {
            charge = new PriceEntity();
            charge.setChargeItemUuid(uuid);
        }

        if (request.getNormalPrice() != null && request.getNormalPrice() > 0)
            charge.setNormalPrice(request.getNormalPrice());
        else if (request.getMemberPrice() != null && request.getMemberPrice() > 0)
            charge.setMemberPrice(request.getMemberPrice());

        return priceRepository.save(charge);
    }

}
