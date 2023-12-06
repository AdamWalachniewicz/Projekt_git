package com.example.Projekt.repository;

import com.example.Projekt.domain.EventEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    public List<EventEntity> findAll();

    public EventEntity findByName(String name);

}
