package com.jose.pc2.activemq;

import com.jose.pc2.domain.Aliado;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @JmsListener(destination = "test-object")
    public void listen(Aliado message) {
        System.out.println("Received message: " + message.toString());
    }
}
