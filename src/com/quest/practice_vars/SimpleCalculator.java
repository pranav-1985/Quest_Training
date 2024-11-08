package com.quest.practice_vars;

import java.util.Scanner;

import static java.lang.System.exit;

public class SimpleCalculator {
    static boolean again = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting number: ");
        int result = sc.nextInt();

        while (again) {
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
                    int addNum = sc2.nextInt();
                    result = result + addNum;
                    System.out.println("\ncurrent result is: " + result);
                    doAgain();
                    break;
                case 2:
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("Enter the number to subtract: ");
                    int subNum = sc3.nextInt();
                    result = result - subNum;
                    System.out.println("\ncurrent result is: " + result);
                    doAgain();
                    break;
                case 3:
                    Scanner sc4 = new Scanner(System.in);
                    System.out.println("Enter the number to multiply: ");
                    int mulNum = sc4.nextInt();
                    result = result * mulNum;
                    System.out.println("\ncurrent result is: " + result);
                    doAgain();
                    break;
                case 4:
                    Scanner sc5 = new Scanner(System.in);
                    System.out.println("Enter the number to divide: ");
                    int divNum = sc5.nextInt();
                    if (divNum == 0) {
                        System.out.println("Division by zero is not possible. try again");
                        doAgain();
                        break;
                    }
                    result = result / divNum;
                    System.out.println("\ncurrent result is: " + result);
                    doAgain();
                    break;
                case 5:
                    result = (int) Math.sqrt(result);
                    System.out.println("\ncurrent result is: " + result);
                    doAgain();
                    break;
                case 6:
                    result = 0;
                    System.out.println("\ncurrent result is: " + result);
                    doAgain();
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

    private static void doAgain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to continue? (Y/N)");
        String yesorno = sc.nextLine();
        if (yesorno == "n" || yesorno == "N") {
            again = false;
        } else if (yesorno == "y" || yesorno == "Y") {
            again = true;
        } else {
            System.out.println("Invalid option");
            doAgain();
        }
        return;

    }
}