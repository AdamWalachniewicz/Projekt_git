package com.example.Projekt.service;

import com.example.Projekt.domain.EventEntity;
import com.example.Projekt.domain.OrderEntity;
import com.example.Projekt.domain.TicketEntity;
import com.example.Projekt.repository.EventRepository;
import com.example.Projekt.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public EventEntity getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public EventEntity getEventByName(String name) {
        return eventRepository.findByName(name);
    }
    @Override
    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll();
    }
    public List<TicketEntity> showTickets(Long eventId) {
        EventEntity event = eventRepository.findById(eventId).orElseThrow();
        return ticketRepository.findAllByEvent(event);
    }
    @Override
    public EventEntity save(EventEntity event) { return eventRepository.save(event);
    }
}
