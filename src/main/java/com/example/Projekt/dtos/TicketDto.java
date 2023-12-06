package com.example.Projekt.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TicketDto {
    private Long id;
    private Double price;
    private String discount;
}
