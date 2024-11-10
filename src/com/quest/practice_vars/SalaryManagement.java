package com.quest.practice_vars;

import java.util.Scanner;

public class SalaryManagement {
    //employee class
    public static class Employee {
        String name;
        int salary;
        int bonus;
        int duration;
        int recievedBonusNum = 0;
        int totalBonus;
        int totalSalary;

        //constructor of employee
        public Employee(String name, int salary, int bonus, int duration) {
            this.name = name;
            this.salary = salary;
            this.bonus = bonus;
            this.duration = duration;

            //adds bonus every 6 months only...finding how many 6 months
            for (int j = 1; j <= this.duration; j++) {
                if (j % 6 == 0) {
                    this.recievedBonusNum++;
                }
            }
            this.totalBonus = this.bonus * this.recievedBonusNum;
            this.totalSalary = (this.salary * this.duration) + this.totalBonus;
        }

        //method for displaying data
        public void displayInfo() {
            System.out.println("\nEmployee Name: " + name + ",\n" +
                    "Base Salary: " + salary + ",\n");
            System.out.println("Monthly Salary Breakdown:\n");
            //to display bonus added salary for every 6 months
            for (int i = 1; i <= this.duration; i++) {
                if (i % 6 == 0) {
                    System.out.println("Month " + i + ": " + (this.salary + this.bonus));
                    continue;
                }
                System.out.println("Month " + i + ": " + this.salary);
            }
            System.out.println("\nTotal Salary for the duration: " + totalSalary);
            System.out.println("\nAverage monthly salary: " + totalSalary / this.duration);
            System.out.println("\nTotal bonus for the duration: " + totalBonus);
        }
    }


    static int averageTotalSalary;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numOfEmployees = isValidNumber(sc, "\nEnter the number of the employees : ");
        Employee[] employee = new Employee[numOfEmployees];//object array creation
        //data input
        for (int i = 0; i < numOfEmployees; i++) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("\n\nEnter the name of employee " + (i + 1) + " : ");
            String name = sc1.nextLine();
            while (!isValidName(name)) {
                System.out.println("Invalid name, try again");
                name = sc1.nextLine();
            } //checking if name is valid
            int salary = isValidNumber(sc1, "\nEnter the salary of employee " + (i + 1) + " : ");
            int bonus = isValidNumber(sc1, "\nEnter the bonus of employee " + (i + 1) + " : ");
            int duration = isValidNumber(sc1, "\nEnter the duration of employee " + (i + 1) + " : ");
            //creating object and placing in object array
            employee[i] = new Employee(name, salary, bonus, duration);
        }

        //for printing report
        System.out.println("\n---Employee Salary Report---\n");
        for (int i = 0; i < numOfEmployees; i++) {
            employee[i].displayInfo();
        }
        System.out.println("\n--------------------------");


        //to calculate and print Average Salary for all employees
        int totalSalary = 0;
        for (int i = 0; i < numOfEmployees; i++) {
            totalSalary += employee[i].totalSalary;
        }
        averageTotalSalary = totalSalary / numOfEmployees;
        System.out.println("\nAverage Salary for all employees: " + averageTotalSalary);
        System.out.println("\nThank you for using the Employee Salary Management System.");
    }

    //checking if name is a string or not
    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    public static int isValidNumber(Scanner sc, String prompt) {
        int number = -1;
        while (number <= 0) {
            System.out.println(prompt);
            try {
                number = sc.nextInt();
                if (number <= 0) {
                    System.out.println("Invalid number, try again");
                }
            } catch (Exception e) {
                System.out.println("Invalid input , try again");
                sc.next();
            }
        }
        return number;
    }

}
