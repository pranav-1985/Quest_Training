package com.quest.oops.lambdaexamples;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PurchaseOperation purchaseOperation = new PurchaseOperation();

        // Sample books
        Book book1 = new Book("Mockingbird", "Harper Lee", 30, 12);
        Book book2 = new Book("Pride", "Jane Austen", 50, 8);
        Book specialBook1 = new SpecialEditionBook("Harry Potter", "J.K. Rowling", 50, 1, "Hardcover");
        Book specialBook2 = new SpecialEditionBook("Gatsby", "F. Scott Fitzgerald", 40, 5, "Leather Bound");
        Book specialBook3 = new SpecialEditionBook("1984", "George Orwell", 45, 0, "Collector's Edition");

        purchaseOperation.addBook(book1);
        purchaseOperation.addBook(book2);
        purchaseOperation.addBook(specialBook1);
        purchaseOperation.addBook(specialBook2);
        purchaseOperation.addBook(specialBook3);

        Scanner scanner = new Scanner(System.in);
        int option;


        do {
            System.out.println("\nEnter the option\n" +
                    "1) Buy book\n" +
                    "2) Display books over a price\n" +
                    "3) Display all books\n" +
                    "4) Exit");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    try {
                        System.out.println("Enter the name of the book:");
                        String name = scanner.nextLine();
                        purchaseOperation.buyBook(name);
                        System.out.println("Book purchased successfully.");
                    } catch (OutOfStockException e) {
                        System.out.println("Book does not have enough stock.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the price:");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    purchaseOperation.getBooksOver(price);
                    break;
                case 3:
                    purchaseOperation.displayAllBooks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } while (option != 4);

        scanner.close();
    }
}
