package com.example.Projekt.repository;

import com.example.Projekt.domain.ClientEntity;
import com.example.Projekt.domain.EventEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EventRepositoryTest {
    EventEntity event;
    @BeforeEach
    void init() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        event = new EventEntity(null, "Great Tour", formatter.parse("2001-05-05"), new ArrayList<>(), new ArrayList<>());
    }
    @Test
    void tesClientNameAndDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        assertAll("Client name and surname",
                () -> assertEquals("Great Tour", event.getName()),
                () -> assertEquals(formatter.parse("2001-05-05"), event.getDate()));
    }
}