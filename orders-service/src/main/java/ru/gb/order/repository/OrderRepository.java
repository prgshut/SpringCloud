package ru.gb.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.order.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
