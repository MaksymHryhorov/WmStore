package com.organisation.WmStore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.organisation.WmStore.controller.ProductController;
import com.organisation.WmStore.model.Product;
import com.organisation.WmStore.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WmStoreApplicationTests {
    private final String path = "D:\\Projects\\WmStore\\src\\main\\java\\com\\organisation\\WmStore\\products.json";
    private final ProductService productService;
    private final ProductController controller;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    WmStoreApplicationTests(ProductService productService, ProductController controller) {
        this.productService = productService;
        this.controller = controller;
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void addProduct() {
        Product[] productList = new Product[0];

        try {
            productList = mapper.readValue(new File(path), Product[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Product product : productList) {
            assertEquals(new ResponseEntity<>(product, HttpStatus.CREATED), controller.addProduct(product));
            controller.deleteProduct(product.getId());
        }

    }

    @Test
    public void deleteProduct() {
        List<Product> productList = productService.findAllProducts();

        for (Product product : productList) {
            if (product.getId() > 30) {
                //assertEquals(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR), controller.deleteProduct());
                assertEquals(new ResponseEntity<>(HttpStatus.NO_CONTENT), controller.deleteProduct(product.getId()));
            }
        }

    }

    @Test
    public void getAllProducts() {
        assertEquals(HttpStatus.OK, controller.getAllProducts().getStatusCode());
    }

    @Test
    public void getById() {
        Product id = productService.findById(29l);
        long testId = 0;

        assertEquals(HttpStatus.OK, controller.getById(id.getId()).getStatusCode());
        //assertEquals(new ProductNotFoundException("Product by id " + testId + " was not found"), controller.getById(testId));
    }

}
