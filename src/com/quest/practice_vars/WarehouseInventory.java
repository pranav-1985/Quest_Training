package com.quest.practice_vars;

import java.util.ArrayList;
import java.util.Scanner;

public class WarehouseInventory {

    public static class Product {
        String productName;
        double productPrice;
        int productQuantity;
        int soldQuantity;

        public Product(String ProductName, double ProductPrice, int ProductQuantity) {
            this.productName = ProductName;
            this.productPrice = ProductPrice;
            this.productQuantity = ProductQuantity;
            this.soldQuantity = 0;
        }
    }

    public static ArrayList<Product> products = new ArrayList<>();


    // Checking if name is a valid string (only alphabets and spaces)
    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    // Checking if number is a positive integer
    public static int isValidNumber(Scanner sc, String prompt) {
        int number = -1;
        while (number <= 0) {
            System.out.println(prompt);
            try {
                number = sc.nextInt();
                if (number < 0) {
                    System.out.println("Invalid number, try again");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, try again");
                sc.next(); // Clear the invalid input
            }
        }
        sc.nextLine(); // Clear the newline character after nextInt
        return number;
    }

    public static double isValidDouble(Scanner sc, String prompt) {
        double number = -1.00;
        while (number <= 0.00) {
            System.out.println(prompt);
            try {
                number = sc.nextDouble();
                if (number <= 0.00) {
                    System.out.println("Invalid number, try again");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, try again");
                sc.next(); // Clear the invalid input
            }
        }
        sc.nextLine(); // Clear the newline character after nextDouble
        return number;
    }

    public static void ProductData(Scanner sc, int numOfNewProducts, ArrayList<Product> products) {

        System.out.println("--Enter products, their price, and quantity--");
        for (int i = 0; i < numOfNewProducts; i++) {
            System.out.println("\nEnter the name of Product " + (products.size() + 1) + " : ");
            String productName = sc.nextLine();
            while (!isValidName(productName)) {
                System.out.println("Invalid name, try again");
                productName = sc.nextLine();
            }
            double productPrice = isValidDouble(sc, "Enter product price");
            int productQuantity = isValidNumber(sc, "Enter product quantity");
            products.add(new Product(productName, productPrice, productQuantity));
        }
    }


    public static void SalesData(Scanner sc, int numOfProducts, ArrayList<Product> products) {

        for (int i = 0; i < numOfProducts; i++) {
            int quantity;
            while (true) {  // Repeat until a valid quantity is entered
                quantity = isValidNumber(sc, "Enter the sold quantity of product " + products.get(i).productName);
                if (quantity >= products.get(i).productQuantity) {
                    System.out.println("Not enough stock. Available quantity for " + products.get(i).productName + ": " + products.get(i).productQuantity);
                } else {
                    break;  // Exit loop if quantity is valid
                }
            }

            // Update product's sold quantity and decrease available quantity
            products.get(i).soldQuantity += quantity;
            products.get(i).productQuantity -= quantity;

            System.out.println("Sold " + quantity + " units of " + products.get(i).productName + ". Remaining stock: " + products.get(i).productQuantity);
        }
    }

    public static void StockQuantityChecker(Scanner sc, int numOfProducts, ArrayList<Product> products) {
        System.out.println("Available products:");
        for (int i = 0; i < numOfProducts; i++) {
            System.out.println((i + 1) + ") " + products.get(i).productName);
        }
        System.out.println("enter the product number(1,2,3...) to check stock availability");
        int pNum = sc.nextInt() - 1;
        System.out.println("enter the required quantity ");
        int reqNum = sc.nextInt();
        if (reqNum >= products.get(pNum).productQuantity) {
            System.out.println("Not enough stock. Available quantity for " + products.get(pNum).productName + ": " + products.get(pNum).productQuantity);
        }
    }

    public static void RestockData(Scanner sc, int numOfProducts, ArrayList<Product> products) {

        System.out.println("Available products:");
        for (int i = 0; i < numOfProducts; i++) {
            System.out.println((i + 1) + ") " + products.get(i).productName);
        }
        System.out.println("enter the product number(1,2,3...) to restock");
        int productNum = sc.nextInt() - 1;
        System.out.println("enter the amount to restock");
        int amount = isValidNumber(sc, "Enter amount to restock");
        products.get(productNum).productQuantity += amount;
        System.out.println(products.get(productNum).productName + " restocked to " + products.get(productNum).productQuantity);
    }

    public static void GenerateSalesReport(Scanner sc, int numOfProducts, ArrayList<Product> products) {

        System.out.println("enter the min price");
        int minPrice = isValidNumber(sc, "Enter minimum price");
        System.out.println("enter the max price");
        int maxPrice = isValidNumber(sc, "Enter maximum price");
        System.out.println("\nSales Report for products priced between " + minPrice + " and " + maxPrice + ":");

        boolean foundInRange = false;
        int totalRevenue = 0;
        for (int i = 0; i < numOfProducts; i++) {
            if (products.get(i).productPrice >= minPrice && products.get(i).productPrice <= maxPrice) {
                foundInRange = true;
                System.out.println("Product " + products.get(i).productName + " has sold "
                        + products.get(i).soldQuantity + " units" + ", Revenue" +
                        (products.get(i).soldQuantity * products.get(i).productPrice));
                totalRevenue += products.get(i).soldQuantity * products.get(i).productPrice;
            }
        }
        System.out.println("\nTotal revenue: " + totalRevenue + "\n");
        if (!foundInRange) {
            System.out.println("No products found within the specified price range.");
        }
    }

    public static void DetectStockOut(ArrayList<Product> products) {
        System.out.println("\nOut of Stock Products:");

        boolean stockOutFound = false;
        for (Product product : products) {
            if (product.productQuantity == 0) {
                System.out.println("- " + product.productName);
                stockOutFound = true;
            }
        }

        if (!stockOutFound) {
            System.out.println("All products are in stock.");
        }
    }

    public static void main(String[] args) {

        boolean pExit = false;
        while (!pExit) {
            System.out.println("welcome to Inventory Manager\n" +
                    "select option\n" +
                    "1)enter stock data\n" +
                    "2)enter sales data\n" +
                    "3)enter check stock available\n" +
                    "4)Restock products\n" +
                    "5)find out of stock products\n" +
                    "6)Generate sales Report\n" +
                    "7)Exit\n");

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    int numOfNewProducts = isValidNumber(sc, "Enter number of new products");
                    ProductData(sc, numOfNewProducts, products);
                    break;
                case 2:
                    System.out.println("Enter the sales data");
                    SalesData(sc, products.size(), products);
                    break;
                case 3:
                    StockQuantityChecker(sc, products.size(), products);
                    break;
                case 4:
                    boolean answer = true;
                    while (answer) {
                        System.out.println("Do you want to restock the products? (y/n)");
                        sc.nextLine();
                        String yOrN = sc.nextLine();
                        if (yOrN.equalsIgnoreCase("y")) {
                            RestockData(sc, products.size(), products);
                        } else {
                            answer = false;
                        }

                    }
                    break;
                case 5:
                    DetectStockOut(products);
                    break;
                case 6:
                    System.out.println("\n do you want to display sales report(y/n)");
                    sc.nextLine();
                    String yOrN = sc.nextLine();
                    if (yOrN.equalsIgnoreCase("y")) {
                        GenerateSalesReport(sc, products.size(), products);
                    }
                    break;
                case 7:
                    pExit = true;
                    break;

                default:
                    System.out.println("Invalid option, try again");
                    break;
            }
        }

    }

}
