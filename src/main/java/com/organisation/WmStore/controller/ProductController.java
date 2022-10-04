package com.organisation.WmStore.controller;

import com.organisation.WmStore.model.Product;
import com.organisation.WmStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@RestController
@CrossOrigin(origins="http://localhost:4200", methods = {RequestMethod.DELETE,
RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Product list from database
     * @return http status
     */
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Get product by id
     * @param id product
     * @return http status
     */
    @GetMapping("{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id) {
        Product product = productService.findById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * Add product to database
     * @param product (name, country, img, price)
     * @return http status
     */
    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addProduct = productService.addProduct(product);

        return new ResponseEntity<>(addProduct, HttpStatus.CREATED);
    }

    /**
     * Update product in database
     * @param product (name, country, img, price)
     * @return http status
     */
    @PutMapping()
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updateProduct = productService.updateProduct(product);

        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    /**
     * Delete product by id
     * @param id product
     * @return http status
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
