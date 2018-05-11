package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.constants.ConfigurationConstants;
import com.isaac.pethospital.procurement.entities.ProcurementConfigurationEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementConfigurationRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcurementConfigurationServiceImpl implements ProcurementConfigurationService {

    private final ProcurementConfigurationRepository procurementConfigurationRepository;

    public ProcurementConfigurationServiceImpl(ProcurementConfigurationRepository procurementConfigurationRepository) {
        this.procurementConfigurationRepository = procurementConfigurationRepository;
    }

    @Override
    public String getOrderNumber() {
        ProcurementConfigurationEntity pce1 = this.procurementConfigurationRepository.findByKey(ConfigurationConstants.OrderNumber);
        String length = this.procurementConfigurationRepository.findByKey(ConfigurationConstants.OrderNumberLength).getValue();
        Long orderNumberLong = Long.parseLong(pce1.getValue());
        String formatString = String.format("%%0%sd", length);
        pce1.setValue(Long.toString(orderNumberLong + 1));
        this.procurementConfigurationRepository.save(pce1);

        return String.format(formatString, orderNumberLong);
    }
}
