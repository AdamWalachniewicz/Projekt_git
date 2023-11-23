package com.example.Projekt.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderDto {
    private Long id;
    private Double quantity;
    private Double sum;
}
