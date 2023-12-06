package com.example.Projekt.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;

//    public ClientEntity() {
//    }
//
//    public ClientEntity(String name, String surname, String email) {
//        this.name = name;
//        this.surname = surname;
//        this.email = email;
//    }

    @OneToMany(mappedBy = "client")
    List<OrderEntity> orders;
}
