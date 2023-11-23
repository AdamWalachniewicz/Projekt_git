package com.example.Projekt.service;

import com.example.Projekt.domain.ClientEntity;
import com.example.Projekt.domain.OrderEntity;
import com.example.Projekt.domain.TicketEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//@Transactional
public interface OrderService {
    public OrderEntity getOrderById(Long id);
    public List<OrderEntity> getAllOrders();
    public boolean exists (Long id);
    public List<TicketEntity> showTickets(Long orderId);
    public OrderEntity save(OrderEntity order);
}
