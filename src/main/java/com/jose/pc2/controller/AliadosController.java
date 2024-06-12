package com.jose.pc2.controller;

import com.jose.pc2.domain.Aliado;
import com.jose.pc2.dto.Consulta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/Aliados")
public class AliadosController {


    @PostMapping
    public ResponseEntity<Aliado[]> createConsulta(@RequestBody Consulta consulta){
        System.out.println("Direccion: " + consulta.url() + " Codigo: " + consulta.Codigo());
        String query = consulta.url() + "/" + consulta.Codigo();
        RestTemplate restTemplate = new RestTemplate();
        var resp = restTemplate.getForObject(query, Aliado[].class);
        return new ResponseEntity<Aliado[]>(resp, HttpStatus.CREATED);
    }

}
