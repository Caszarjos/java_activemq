package com.jose.pc2.activemq;

import com.jose.pc2.domain.Aliado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String destination, Aliado message) {
        jmsTemplate.convertAndSend(destination, message);
    }
}