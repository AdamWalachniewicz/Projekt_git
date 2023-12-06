package com.example.Projekt.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ClientDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
}
