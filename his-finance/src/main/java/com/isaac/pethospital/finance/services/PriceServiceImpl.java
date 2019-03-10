package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.common.jms.finance.PriceItemOperationMessage;
import com.isaac.pethospital.finance.dtos.PriceOperationRequest;
import com.isaac.pethospital.finance.entities.PriceEntity;
import com.isaac.pethospital.finance.repositories.PriceRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void onPriceItemEventReceived(PriceItemOperationMessage mesassge) {

        switch (mesassge.getOperationEnum()) {

            case CREATE:
                PriceEntity priceEntity = new PriceEntity();
                priceEntity.setPriceItemUuid(mesassge.getUuid());
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
        return this.priceRepository.findByPriceItemUuidIn(request.getUuids());
    }

    @Override
    public PriceEntity findByUuid(String uuid) {

        PriceEntity charge = this.priceRepository.findByPriceItemUuid(uuid);
        if (charge == null)
            return new PriceEntity();
        else return charge;
    }

    @Override
    public PriceEntity update(PriceOperationRequest request) {
        String uuid = request.getUuid();
        if (StringUtils.isEmpty(uuid))
            throw new RuntimeException("Uuid is null");
        PriceEntity charge = this.priceRepository.findByPriceItemUuid(uuid);
        if (charge == null) {
            charge = new PriceEntity();
            charge.setPriceItemUuid(uuid);
        }

        if (request.getNormalPrice() != null && request.getNormalPrice().compareTo(new BigDecimal(0)) > 0)
            charge.setNormalPrice(request.getNormalPrice());
        else if (request.getMemberPrice() != null && request.getMemberPrice().compareTo(new BigDecimal(0)) > 0)
            charge.setMemberPrice(request.getMemberPrice());

        return priceRepository.save(charge);
    }

}
