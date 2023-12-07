package com.example.Projekt.service;

import com.example.Projekt.domain.TicketEntity;

import java.util.List;

public interface TicketService {
    public TicketEntity getTicketById(Long id);

    public List<TicketEntity> getAllTickets();

    public boolean exists(Long id);

    public TicketEntity save(TicketEntity ticket);
}
