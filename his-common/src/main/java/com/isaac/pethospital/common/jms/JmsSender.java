package com.isaac.pethospital.common.jms;

import org.springframework.jms.core.JmsTemplate;

public class JmsSender {

    private JmsTemplate jmsTemplate;
    String queue;

    public JmsSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public <T> void sendEvent(String queue,T args) {
        this.jmsTemplate.convertAndSend(queue, args);
    }
}

