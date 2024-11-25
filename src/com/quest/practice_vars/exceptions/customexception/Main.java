package com.quest.practice_vars.exceptions.customexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean input = false;

        Employee employee = null;
        Manager manager = null;

        while (!input) {
            try {
                System.out.println("Enter Employee Details:");
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Age: ");
                int age = sc.nextInt();
                System.out.print("Salary: ");
                double salary = sc.nextDouble();
                employee = new Employee(name, age, salary);
                input = true;
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter a valid input.");
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter valid data types.");
                sc.next();
            }
        }

        input = false;
        while (!input) {
            try {
                System.out.println("\nEnter Manager Details:");
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Age: ");
                int age = sc.nextInt();
                System.out.print("Salary: ");
                double salary = sc.nextDouble();
                System.out.print("Team Size: ");
                int teamSize = sc.nextInt();

                manager = new Manager(name, age, salary, teamSize);
                input = true;

            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter a valid input.");
                sc.nextLine();

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter a valid input.");
                sc.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter valid data type.");
                sc.next();
            }
        }


        System.out.println("\nDisplaying Employee Details:");
        employee.displayDetails();

        System.out.println("\nDisplaying Manager Details:");
        manager.displayDetails();

    }
}
