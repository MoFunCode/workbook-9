package com.pluralsight.NorthwindTradersAPI.controller;

import com.pluralsight.NorthwindTradersAPI.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    private final List<Category> categories;

    public CategoriesController() {
        categories = new ArrayList<>();
        categories.add(new Category(1, "Electronics"));
        categories.add(new Category(2, "Food & Beverages"));
        categories.add(new Category(3, "Clothing"));
        categories.add(new Category(4, "Books"));
        categories.add(new Category(17, "Home & Garden"));
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categories;
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable int id) {
        for (Category category : categories) {
            if (category.getCategoryId() == id) {
                return category;
            }

        }
        return null;
    }

}
