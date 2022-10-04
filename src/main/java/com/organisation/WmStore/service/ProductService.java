package com.organisation.WmStore.service;

import com.organisation.WmStore.exception.ProductNotFoundException;
import com.organisation.WmStore.model.Product;
import com.organisation.WmStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepo;

    @Autowired
    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    /**
     * Add product to database
     * @param product
     * @return
     */
    public Product addProduct(Product product) {

        return productRepo.save(product);
    }

    /**
     * Find product
     * @return Product list
     */
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    /**
     * Update product
     * @param product for update
     * @return Product
     */
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    /**
     * Delete product by id
     * @param id product
     */
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    /**
     * Find product by id
     * @param id product
     * @return Product
     * @throws ProductNotFoundException
     */
    public Product findById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product by id " + id + " was not found"));
    }

}
