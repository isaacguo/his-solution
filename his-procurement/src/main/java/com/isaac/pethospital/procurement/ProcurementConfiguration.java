package com.isaac.pethospital.procurement;

import com.isaac.pethospital.common.security.AuthHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcurementConfiguration {

    @Bean
    public AuthHelper getAuthHelper() {
        return new AuthHelper();
    }
}
