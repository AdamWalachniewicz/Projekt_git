package com.example.Projekt.dtos;

import com.example.Projekt.domain.ClientEntity;
import com.example.Projekt.domain.TicketEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketDtoMapper {
    static public List<TicketDto> mapToTicketDtos(List<TicketEntity> tickets) {
        return tickets.stream().map(TicketDtoMapper::mapToTicketDto).toList();
    }

    static public TicketDto mapToTicketDto(TicketEntity ticket) {
        return TicketDto.builder()
                .id(ticket.getId())
                .price(ticket.getPrice())
                .discount(ticket.getDiscount())
                .build();
    }
}
