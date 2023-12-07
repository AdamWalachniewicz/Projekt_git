package com.example.Projekt.dtos;

import com.example.Projekt.domain.EventEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventDtoMapper {
    static public List<EventDto> mapToEventDtos(List<EventEntity> events) {
        return events.stream().map(EventDtoMapper::mapToEventDto).toList();
    }

    static public EventDto mapToEventDto(EventEntity event) {
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .date(event.getDate())
                .bands(event.getBands())
                .build();
    }
}
