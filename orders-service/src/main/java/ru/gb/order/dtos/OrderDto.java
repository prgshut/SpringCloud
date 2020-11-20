package ru.gb.order.dtos;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

   private Long id;
    private Float price;
    private List<OrderItemDto> items;

}
