package com.example.Projekt.controller;

import com.example.Projekt.domain.TicketEntity;
import com.example.Projekt.dtos.TicketDto;
import com.example.Projekt.dtos.TicketDtoMapper;
import com.example.Projekt.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketRestController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/tickets")
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketEntity ticket) {
        HttpStatus status = HttpStatus.CREATED;
        TicketEntity saved = ticketService.save(ticket);
        return new ResponseEntity<>(TicketDtoMapper.mapToTicketDto(saved), status);
    }

    @GetMapping("/tickets")
    public List<TicketDto> getAllTickets() {

        return TicketDtoMapper.mapToTicketDtos(ticketService.getAllTickets());
    }
}
