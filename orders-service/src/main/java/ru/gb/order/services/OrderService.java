package ru.gb.order.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.order.dtos.OrderDto;
import ru.gb.order.dtos.OrderItemDto;
import ru.gb.order.dtos.ProductDto;
import ru.gb.order.entities.Order;
import ru.gb.order.entities.OrderItem;
import ru.gb.order.repository.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    private final Function<Order, OrderDto> mapToDto = (order) -> {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setPrice(order.getPrice());
        orderDto.setItems(order.getItems().stream().map(this::mapOrderItemToDto).collect(Collectors.toList()));
        return orderDto;
    };

    public List<OrderDto> findAllOrders() {
        return orderRepository.findAll().stream().map(mapToDto).collect(Collectors.toList());
    }

    public Optional<OrderDto> findById(Long id) {
        return orderRepository.findById(id).map(mapToDto);
    }


    private OrderItemDto mapOrderItemToDto(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setPrice(orderItem.getPrice());
        orderItemDto.setPricePerProduct(orderItem.getPricePerProduct());
        orderItemDto.setProductId(orderItem.getProductId());
        orderItemDto.setQuantity(orderItem.getQuantity());
        return orderItemDto;
    }
}
