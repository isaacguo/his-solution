package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.common.services.FactoryResetService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FactoryResetServiceImpl implements FactoryResetService {
    @Transactional
    @Override
    public void reset() {

    }

    @Override
    public void insertData() {

    }
}
