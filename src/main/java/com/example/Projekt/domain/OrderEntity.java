package com.example.Projekt.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order")
@Getter
@Setter
@Data
public class OrderEntity {
    public OrderEntity() {
    }

    public OrderEntity(Double quantity, Double sum) {
        this.quantity = quantity;
        this.sum = sum;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double quantity;
    private Double sum;
}
