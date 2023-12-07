package com.example.Projekt.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double quantity;
    private Double sum;


    @ManyToOne
    @JoinColumn(name = "client_id")
    ClientEntity client;

    @OneToMany(mappedBy = "orders")
    List<TicketEntity> tickets;
}
