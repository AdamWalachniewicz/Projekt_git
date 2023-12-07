package com.example.Projekt.repository;

import com.example.Projekt.domain.ClientEntity;
import com.example.Projekt.domain.OrderEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderRepositoryTest {

    OrderEntity order;

    @BeforeEach
    void init() throws IOException, Exception {
        order = new OrderEntity(null, 2.0, 240.0, new ClientEntity(), new ArrayList<>());
    }

    @Test
    void tesOrderSumAndQuantity() throws Exception {
        assertAll("Order sum",
                () -> assertEquals(240.0, order.getSum()),
                () -> assertEquals(2.0, order.getQuantity()));
    }

}