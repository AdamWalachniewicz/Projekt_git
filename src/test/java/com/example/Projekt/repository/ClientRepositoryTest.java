package com.example.Projekt.repository;

import com.example.Projekt.domain.ClientEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTest {
    ClientEntity client;

    @BeforeEach
    void init() {
        client = new ClientEntity(null, "Jan", "Nowak", "j.nowak@wp.pl", new ArrayList<>());
    }

    @Test
    void tesClientNameAndSurname() {
        assertAll("Client name and surname",
                () -> assertEquals("Jan", client.getName()),
                () -> assertEquals("Nowak", client.getSurname()));
    }


}