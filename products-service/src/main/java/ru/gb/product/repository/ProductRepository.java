package ru.gb.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.product.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
