package com.organisation.WmStore.repository;

import com.organisation.WmStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteById(Long id);

    Optional<Product> findById(Long id);
}
