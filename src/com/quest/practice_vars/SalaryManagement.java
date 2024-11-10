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
        System.out.println("\nEnter the number of the employees : ");
        int numOfEmployees;
        try {
            numOfEmployees = sc.nextInt();
            if (numOfEmployees <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("invalid input, try again");
            numOfEmployees = sc.nextInt();
        }
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
            System.out.println("Enter the salary of employee " + (i + 1) + " : ");
            int salary;
            try {
                salary = sc1.nextInt();
                if (salary <= 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid salary, try again");
                salary = sc.nextInt();
            }//handling double and negative inputs
            System.out.println("Enter the bonus of employee " + (i + 1) + " : ");
            int bonus;
            try {
                bonus = sc.nextInt();
                if (bonus < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid bonus, try again");
                bonus = sc.nextInt();
            }//handling double and negative inputs
            System.out.println("Enter the duration of employee " + (i + 1) + " : ");
            int duration;
            try {
                duration = sc.nextInt();
                if (duration < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid duration, try again");
                duration = sc.nextInt();
            }//handling double and negative inputs
            employee[i] = new Employee(name, salary, bonus, duration);//creating object and placing in object array
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

}
