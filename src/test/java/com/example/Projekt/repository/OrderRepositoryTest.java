package com.example.Projekt.repository;

import com.example.Projekt.domain.ClientEntity;
import com.example.Projekt.domain.EventEntity;
import com.example.Projekt.domain.OrderEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    OrderEntity order;
    @BeforeEach
    void init() throws IOException, Exception {
        order = new OrderEntity(null, 2.0, 240.0, new ClientEntity(), new ArrayList<>());
    }
    @Test
    void tesOrderSumAndQuantity() throws Exception{
        assertAll("Order sum",
                () -> assertEquals(240.0, order.getSum()),
                () -> assertEquals(2.0, order.getQuantity()));
    }

}