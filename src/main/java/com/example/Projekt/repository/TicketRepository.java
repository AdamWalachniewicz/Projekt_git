package com.example.Projekt.repository;

import com.example.Projekt.domain.EventEntity;
import com.example.Projekt.domain.OrderEntity;
import com.example.Projekt.domain.TicketEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    public List<TicketEntity> findAll();

    List<TicketEntity> findAllByOrders(OrderEntity orders);

    List<TicketEntity> findAllByEvent(EventEntity event);
}
