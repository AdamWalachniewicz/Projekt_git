package com.example.Projekt.service;

import com.example.Projekt.domain.EventEntity;
import com.example.Projekt.domain.TicketEntity;

import java.util.List;

public interface EventService {
    public EventEntity getEventById(Long id);
    public EventEntity getEventByName(String name);
    public List<EventEntity> getAllEvents();
    public List<TicketEntity> showTickets(Long eventId);
    public EventEntity save(EventEntity event);
}
