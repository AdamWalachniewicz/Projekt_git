package com.example.Projekt.controller;


import com.example.Projekt.domain.ClientEntity;
import com.example.Projekt.dtos.ClientDto;
import com.example.Projekt.dtos.ClientDtoMapper;
import com.example.Projekt.dtos.OrderDto;
import com.example.Projekt.dtos.OrderDtoMapper;
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
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientEntity client) {
        HttpStatus status = HttpStatus.CREATED;
        ClientEntity saved = clientService.save(client);
        return new ResponseEntity<>(ClientDtoMapper.mapToClientDto(saved), status);
    }

    @GetMapping("/clients")
    public List<ClientDto> getAllClients() {
        return ClientDtoMapper.mapToClientDtos(clientService.getAllClients());
    }

    @GetMapping("/clients/{clientId}/orders")
    public List<OrderDto> showOrders(@PathVariable Long clientId) {
        return OrderDtoMapper.mapToOrderDtos(clientService.showOrders(clientId));
    }
}
