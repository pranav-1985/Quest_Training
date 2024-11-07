package com.quest.practice_vars;

import java.util.Scanner;

import static java.lang.System.exit;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting number: ");
        int result = sc.nextInt();
        boolean again = true;
        while (again) {
            System.out.println("\ncurrent result is: " + result);
            Scanner sc1 = new Scanner(System.in);
            System.out.println("\nEnter option:\n " +
                    "1. Addition\n" +
                    "2. Subtraction\n" +
                    "3. Multiplication\n" +
                    "4. Division\n" +
                    "5. Square Root\n" +
                    "6. Clear Current" + " Result\n" +
                    "7. Exit\n");

            System.out.println("\nEnter your choice: ");
            int option = sc1.nextInt();
            switch (option) {
                case 1:
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Enter the number to add: ");
                    int addnum = sc2.nextInt();
                    result = result + addnum;
                    break;
                case 2:
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("Enter the number to subtract: ");
                    int subnum = sc3.nextInt();
                    result = result - subnum;
                    break;
                case 3:
                    Scanner sc4 = new Scanner(System.in);
                    System.out.println("Enter the number to multiply: ");
                    int mulnum = sc4.nextInt();
                    result = result * mulnum;
                    break;
                case 4:
                    Scanner sc5 = new Scanner(System.in);
                    System.out.println("Enter the number to divide: ");
                    int divnum = sc5.nextInt();
                    result = result / divnum;
                    break;
                case 5:
                    result = (int) Math.sqrt(result);
                    break;
                case 6:
                    result = 0;
                    break;
                case 7:
                    again = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;

            }
        }
    }
}
