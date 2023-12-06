package com.example.Projekt.dtos;

import com.example.Projekt.domain.ClientEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientDtoMapper {

    static public List<ClientDto> mapToClientDtos(List<ClientEntity> clients) {
        return clients.stream().map(ClientDtoMapper::mapToClientDto).toList();
    }

    static public ClientDto mapToClientDto(ClientEntity client) {
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .email(client.getEmail())
                .build();
    }
}
