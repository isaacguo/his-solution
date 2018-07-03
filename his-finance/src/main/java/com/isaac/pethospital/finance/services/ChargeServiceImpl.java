package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.finance.repositories.ChargeRepository;
import org.springframework.stereotype.Service;

@Service
public class ChargeServiceImpl implements ChargeService {

    private final ChargeRepository chargeRepository;

    public ChargeServiceImpl(ChargeRepository chargeRepository) {
        this.chargeRepository = chargeRepository;
    }
}
