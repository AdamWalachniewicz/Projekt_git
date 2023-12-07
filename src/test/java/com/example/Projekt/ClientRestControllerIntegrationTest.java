package com.example.Projekt;

import com.example.Projekt.domain.ClientEntity;
import com.example.Projekt.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ProjektApplication.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureTestDatabase
public class ClientRestControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ClientRepository repository;


    @Test
    @Order(1)
    public void whenValidInput_thenCreateStudent() throws IOException, Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        ClientEntity jan = new ClientEntity(null, "Jan", "Smiths", "j.nowak@wp.pl", new ArrayList<>());

        mvc.perform(post("/api/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jan)))
                .andDo(print());
        List<ClientEntity> found = repository.findAll();
        assertThat(found).extracting(ClientEntity::getName)
                .containsOnly("Jan");
    }

    @Test
    public void givenClients_whenGetClients_thenStatus200() throws Exception {
        createTestClient("Andrzej", "Kowalski", "a.kowal@gmail.com");
        createTestClient("Jan", "Skrzetuski", "jwisniowiecki@wp.pl");

        mvc.perform(get("/api/clients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
                .andExpect(jsonPath("$[0].name", is("Andrzej")))
                .andExpect(jsonPath("$[0].surname", is("Kowalski")))
                .andExpect(jsonPath("$[1].name", is("Jan")))
                .andExpect(jsonPath("$[1].surname", is("Skrzetuski")));
    }

    private void createTestClient(String name, String surname, String email) {
        ClientEntity client = new ClientEntity(null, name, surname, email, new ArrayList<>());
        repository.saveAndFlush(client);
    }
}
