package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;


@Component
public class NorthwindApplication implements CommandLineRunner{

    private final IProductDao productDao;
    private final Scanner scanner;

    @Autowired
    public NorthwindApplication(IProductDao productDao) {
        this.productDao = productDao;
        this.scanner = new Scanner(System.in);

    }

    @Override
    public void run(String... args) throws Exception {
        Boolean whileRunning = true;

        while (whileRunning) {
            System.out.println("1. List Products");
            System.out.println("2. Add Product");
            System.out.println("Choose an option bro:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> listProducts();
                case 2 -> addProduct();
                case 3 -> {
                    System.out.println("Ehhhh");
                    whileRunning = false;
                    scanner.close();
                }
            }
        }
    }

    private void listProducts() {
        System.out.println("\nPRODUCTS");
        List<Product> products = productDao.getAll();

        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        System.out.print("Enter Price: ");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();

        Product newProduct = new Product(id, name, category, price);
        productDao.add(newProduct);

        System.out.println("Product added successfully!");
    }

    public void removeProductByID(){
        System.out.println("Enter product ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();


    }
}

