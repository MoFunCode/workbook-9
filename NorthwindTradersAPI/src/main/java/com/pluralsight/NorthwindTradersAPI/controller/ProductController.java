package com.pluralsight.NorthwindTradersAPI.controller;

import com.pluralsight.NorthwindTradersAPI.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private List<Product> products;

    public ProductController() {

        products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 1, new BigDecimal("999.99")));
        products.add(new Product(2, "Mouse", 1, new BigDecimal("25.50")));
        products.add(new Product(3, "Coffee", 2, new BigDecimal("8.99")));
        products.add(new Product(4, "Bread", 2, new BigDecimal("2.50")));

    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return products;

    }




}
