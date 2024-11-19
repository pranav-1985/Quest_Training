package com.quest;

import java.util.Scanner;

public class Validator {

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

    // Checking if number is a valid positive double
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
}
