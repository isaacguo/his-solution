package com.isaac.pethospital.procurement;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.common.security.AuthHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class ProcurementConfiguration {

    @Bean
    public AuthHelper getAuthHelper() {
        return new AuthHelper();
    }

    @Bean
    public DatetimeGenerator getDatetimeGenerator(){
        return new DatetimeGenerator();
    }
}
