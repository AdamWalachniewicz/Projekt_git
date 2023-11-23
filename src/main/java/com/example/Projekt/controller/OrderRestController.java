package com.example.Projekt.controller;

import com.example.Projekt.domain.OrderEntity;
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
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order) {
        HttpStatus status = HttpStatus.CREATED;
        OrderEntity saved = orderService.save(order);
        return new ResponseEntity<>(saved, status);
    }

    @GetMapping("/orders")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }
}
