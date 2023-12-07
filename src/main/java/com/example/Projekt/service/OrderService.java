package com.example.Projekt.service;

import com.example.Projekt.domain.OrderEntity;
import com.example.Projekt.domain.TicketEntity;

import java.util.List;

public interface OrderService {
    public OrderEntity getOrderById(Long id);

    public List<OrderEntity> getAllOrders();

    public boolean exists(Long id);

    public List<TicketEntity> showTickets(Long orderId);

    public OrderEntity save(OrderEntity order);
}
