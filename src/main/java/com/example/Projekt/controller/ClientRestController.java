package com.example.Projekt.controller;


import com.example.Projekt.domain.ClientEntity;
import com.example.Projekt.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/clients")
    public ResponseEntity<ClientEntity> createClient(@RequestBody ClientEntity client) {
        HttpStatus status = HttpStatus.CREATED;
        ClientEntity saved = clientService.save(client);
        return new ResponseEntity<>(saved, status);
    }

    @GetMapping("/clients")
    public List<ClientEntity> getAllClients() {
        return clientService.getAllClients();
    }
}
