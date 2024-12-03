package com.quest.collections.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeSearch {
    public static void main(String[] args) {

        Map<Integer, String> employees = new HashMap<>();
        employees.put(101, "John Doe");
        employees.put(102, "Jane Smith");
        employees.put(103, "Alice Johnson");
        employees.put(104, "Bob Brown");


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID to search: ");
        int searchId = scanner.nextInt();


        String employeeName = employees.get(searchId);

        
        if (employeeName != null) {
            System.out.println("Employee with ID " + searchId + " is: " + employeeName);
        } else {
            System.out.println("Employee with ID " + searchId + " not found.");
        }

        scanner.close();
    }
}
