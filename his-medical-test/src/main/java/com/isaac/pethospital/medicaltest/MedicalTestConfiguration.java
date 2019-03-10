package com.isaac.pethospital.medicaltest;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.common.time.DatetimeGenerator;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

//import com.isaac.pethospital.procurement.jms.JmsProperties;

@Configuration
@EnableConfigurationProperties({JmsProperties.class})
public class MedicalTestConfiguration {

    @Bean
    public HanyuPinyinConverter getHanyuPinyinConverter()
    {
        return new HanyuPinyinConverter();
    }
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
