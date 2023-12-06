package com.example.Projekt.service;

import com.example.Projekt.domain.ClientEntity;
import com.example.Projekt.domain.OrderEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//@Transactional
public interface ClientService {
    public ClientEntity getClientById(Long id);
    public ClientEntity getClientByName(String name, String surname);
    public List<ClientEntity> getAllClients();
    public boolean exists (String email);
    public List<OrderEntity> showOrders(Long clientId);
    public ClientEntity save(ClientEntity client);
}
