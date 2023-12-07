package com.example.Projekt.service;

import com.example.Projekt.domain.EventEntity;
import com.example.Projekt.domain.OrderEntity;
import com.example.Projekt.domain.TicketEntity;
import com.example.Projekt.repository.EventRepository;
import com.example.Projekt.repository.OrderRepository;
import com.example.Projekt.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public TicketEntity getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Order
    public List<TicketEntity> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public boolean exists(Long id) {
        if (ticketRepository.findById(id) != null) {
            return true;
        }
        return false;
    }

    @Override
    public TicketEntity save(TicketEntity ticket) {
        OrderEntity orders = orderRepository.findById(ticket.getOrders().getId())
                .orElseThrow();
        EventEntity event = eventRepository.findById(ticket.getEvent().getId())
                .orElseThrow();

        ticket.setOrders(orders);
        ticket.setEvent(event);
        return ticketRepository.save(ticket);
    }
}
