package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class NorthwindTradersSpringBootApplication {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
        IProductDao dao = context.getBean(IProductDao.class);

        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        System.out.println("Welcome to the Product Management System!");

        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. List Products");
            System.out.println("2. Add Product");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> listProducts(dao);
                case 2 -> addProduct(dao, scanner);
                case 3 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    //List All Products In Memory
    private static void listProducts(IProductDao dao) {
        System.out.println("\n=== ALL PRODUCTS ===");
        List<Product> products = dao.getAll();

        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product product : products) {
                System.out.printf("ID: %d | Name: %s | Category: %s | Price: $%.2f%n",
                        product.getProductId(),
                        product.getName(),
                        product.getCategory(),
                        product.getPrice());
            }
        }
    }

    //Add New Product To Temp Memory
    private static void addProduct(IProductDao dao, Scanner scanner) {

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
        dao.add(newProduct);

        System.out.println("Product added successfully!");
    }
}

