package com.example.Projekt.service;

import com.example.Projekt.domain.ClientEntity;
import com.example.Projekt.domain.OrderEntity;
import com.example.Projekt.repository.ClientRepository;
import com.example.Projekt.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ClientEntity getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public ClientEntity getClientByName(String name, String surname) {
        return clientRepository.findByNameAndSurname(name, surname);
    }
    @Override
    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    public List<OrderEntity> showOrders(Long clientId) {
        ClientEntity client = clientRepository.findById(clientId).orElseThrow();
        return orderRepository.findAllByClient(client);
    }
    @Override
    public boolean exists(String email) {
        if (clientRepository.findByEmail(email)!=null) {
            return true;
        }
        return false;
    }
    @Override
    public ClientEntity save(ClientEntity client) {
        return clientRepository.save(client);
    }

}
