package com.example.Projekt.service;

import com.example.Projekt.domain.ClientEntity;
import com.example.Projekt.domain.OrderEntity;

import java.util.List;


public interface ClientService {
    public ClientEntity getClientById(Long id);

    public ClientEntity getClientByName(String name, String surname);

    public List<ClientEntity> getAllClients();

    public boolean exists(String email);

    public List<OrderEntity> showOrders(Long clientId);

    public ClientEntity save(ClientEntity client);
}
