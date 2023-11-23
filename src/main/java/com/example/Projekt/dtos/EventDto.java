package com.example.Projekt.dtos;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Builder
@Getter
public class EventDto {
    private Long id;
    private String name;
    private Date date;
    private List<String> bands;
}
