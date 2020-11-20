package ru.gb.order.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.order.dtos.OrderDto;
import ru.gb.order.services.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<OrderDto> getById(@PathVariable Long id) {
        return orderService.findById(id);
    }

}
