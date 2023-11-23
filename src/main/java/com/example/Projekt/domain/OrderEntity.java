package com.example.Projekt.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double quantity;
    private Double sum;

    public OrderEntity() {
    }

    public OrderEntity(Double quantity, Double sum) {
        this.quantity = quantity;
        this.sum = sum;
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    ClientEntity client;

    @OneToMany(mappedBy = "orders")
    List<TicketEntity> tickets;
}
