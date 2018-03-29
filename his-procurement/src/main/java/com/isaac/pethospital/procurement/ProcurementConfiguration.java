package com.isaac.pethospital.procurement;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcurementConfiguration {

    @Bean
    public AuthHelper getAuthHelper() {
        return new AuthHelper();
    }



}
