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
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }
    @Override
    public boolean exists(Long id) {
        if (orderRepository.findById(id)!=null) {
            return true;
        }
        return false;
    }
    @Override
    public OrderEntity save(OrderEntity order) {
        return orderRepository.save(order);
    }

}
