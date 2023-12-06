package com.example.Projekt.controller;

import com.example.Projekt.domain.OrderEntity;
import com.example.Projekt.dtos.OrderDto;
import com.example.Projekt.dtos.OrderDtoMapper;
import com.example.Projekt.dtos.TicketDto;
import com.example.Projekt.dtos.TicketDtoMapper;
import com.example.Projekt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderEntity order) {
        HttpStatus status = HttpStatus.CREATED;
        OrderEntity saved = orderService.save(order);
        return new ResponseEntity<>(OrderDtoMapper.mapToOrderDto(saved), status);
    }

    @GetMapping("/orders")
    public List<OrderDto> getAllOrders() {

        return OrderDtoMapper.mapToOrderDtos(orderService.getAllOrders());
    }

    @GetMapping("/orders/{orderId}/tickets")
    public List<TicketDto> showTickets(@PathVariable Long orderId) {
        return TicketDtoMapper.mapToTicketDtos(orderService.showTickets(orderId));
    }
}
