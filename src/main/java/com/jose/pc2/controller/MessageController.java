package com.jose.pc2.controller;

import ch.qos.logback.core.pattern.util.AlmostAsIsEscapeUtil;
import com.jose.pc2.activemq.MessageProducerService;
import com.jose.pc2.domain.Aliado;
import com.jose.pc2.dto.messageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Autowired
    private MessageProducerService messageProducerService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody messageDTO message) {
        Aliado al = new Aliado(
                message.Apertura(),
                message.Categoria(),
                message.Codigo(),
                message.Negocio()
        );
        messageProducerService.sendMessage(message.destination(), al);
        return ResponseEntity.ok("Message sent to " + message.destination());
    }
}