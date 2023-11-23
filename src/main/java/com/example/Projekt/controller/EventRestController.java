package com.example.Projekt.controller;

import com.example.Projekt.domain.EventEntity;
import com.example.Projekt.dtos.*;
import com.example.Projekt.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventRestController {
    @Autowired
    private EventService eventService;

    @PostMapping("/events")
    public ResponseEntity<EventDto> createEvent(@RequestBody EventEntity event) {
        HttpStatus status = HttpStatus.CREATED;
        EventEntity saved = eventService.save(event);
        return new ResponseEntity<>(EventDtoMapper.mapToEventDto(saved), status);
    }

    @GetMapping("/events")
    public List<EventDto> getEvents() {
        return EventDtoMapper.mapToEventDtos(eventService.getAllEvents());
    }

    @GetMapping("/events/{eventId}/tickets")
    public List<TicketDto> showTickets(@PathVariable Long eventId) {
        return TicketDtoMapper.mapToTicketDtos(eventService.showTickets(eventId));
    }
}
