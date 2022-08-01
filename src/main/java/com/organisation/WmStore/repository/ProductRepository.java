package com.organisation.WmStore.repository;

import com.organisation.WmStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteProductById(Long id);

    Optional findProductById(Long id);
}
