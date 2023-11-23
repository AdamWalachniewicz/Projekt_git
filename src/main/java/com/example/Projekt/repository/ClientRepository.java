package com.example.Projekt.repository;

import com.example.Projekt.domain.ClientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    public ClientEntity findByName(String name, String surname);

    public List<ClientEntity> findAll();

    public ClientEntity findByEmail(String email);
}
