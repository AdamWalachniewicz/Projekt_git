package com.example.Projekt.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private String discount;

    @ManyToOne
    @JoinColumn(name = "event_id")
    EventEntity event;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    OrderEntity orders;
}
