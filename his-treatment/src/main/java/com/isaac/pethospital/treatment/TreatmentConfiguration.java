package com.isaac.pethospital.treatment;

import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.common.time.DatetimeGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

//import com.isaac.pethospital.procurement.jms.JmsProperties;

@Configuration
//@EnableConfigurationProperties({JmsProperties.class})
public class TreatmentConfiguration {

    @Bean
    public AuthHelper getAuthHelper() {
        return new AuthHelper();
    }

    @Bean
    public DatetimeGenerator getDatetimeGenerator(){
        return new DatetimeGenerator();
    }

    @Bean
    public JmsSender getJmsSender(JmsTemplate jmsTemplate)
    {
        return new JmsSender(jmsTemplate);
    }
}
