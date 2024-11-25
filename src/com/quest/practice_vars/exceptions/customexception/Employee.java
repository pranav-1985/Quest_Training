package com.quest.practice_vars.exceptions.customexception;

public class Employee {
    private String name;
    private Integer ageObject;
    private double salary;

    public Employee(String name, int age, double salary) throws InvalidInputException {
        this.name = name;
        this.ageObject = age;
        if (age < 18) {
            throw new InvalidInputException("Age cant be less than 18");
        }
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        int age = ageObject;
        return age;
    }

    public void setAge(int age) {
        this.ageObject = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee Name: " + getName());
        System.out.println("Employee Age: " + getAge());
        System.out.println("Employee Salary: " + getSalary());

    }
}
