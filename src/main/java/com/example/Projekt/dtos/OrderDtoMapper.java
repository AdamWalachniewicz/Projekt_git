package com.example.Projekt.dtos;

import com.example.Projekt.domain.OrderEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDtoMapper {

    static public List<OrderDto> mapToOrderDtos(List<OrderEntity> orders) {
        return orders.stream().map(OrderDtoMapper::mapToOrderDto).toList();
    }

    static public OrderDto mapToOrderDto(OrderEntity order) {
        return OrderDto.builder()
                .id(order.getId())
                .quantity(order.getQuantity())
                .sum(order.getSum())
                .build();
    }
}
