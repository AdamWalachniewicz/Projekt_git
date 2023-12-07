package com.example.Projekt.repository;

import com.example.Projekt.domain.EventEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EventRepositoryTest {
    EventEntity event;

    Date formatDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return formatter.parse(date);
    }

    @BeforeEach
    void init() throws IOException, Exception {
        Date date = formatDate("2001-05-05");
        event = new EventEntity(null, "Great Tour", date, new ArrayList<>(), new ArrayList<>());
    }

    @Test
    void tesEventNameAndDate() throws Exception {
        Date date = formatDate("2001-05-05");
        assertAll("Client name and surname",
                () -> assertEquals("Great Tour", event.getName()),
                () -> assertEquals(date, event.getDate()));
    }
}