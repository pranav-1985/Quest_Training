package com.quest.streamstopic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamExample2 {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", 30, "Engineering", 75000, 8));
        employees.add(new Employee(2, "Jane Smith", 27, "Marketing", 65000, 5));
        employees.add(new Employee(3, "Alice Brown", 35, "HR", 80000, 10));
        employees.add(new Employee(4, "Bob White", 45, "Engineering", 90000, 20));
        employees.add(new Employee(5, "John Smith", 27, "Marketing", 65000, 5));


        List<Employee> sortOnSalary = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .toList();
        sortOnSalary.forEach(System.out::println);

        System.out.println("-------------");

        List<Employee> filterBySalary = employees.stream()
                .filter(employee -> employee.getSalary() > 70000).toList();
        filterBySalary.forEach(System.out::println);

        System.out.println("--------");

        Optional<Employee> maxSalary = employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .findFirst();
        System.out.println(maxSalary.get());

        System.out.println("---------");

        List<Employee> skipEmployee = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .skip(2)
                .toList();
        skipEmployee.forEach(System.out::println);

        System.out.println("-------------");
        //Reducing employee data to compute aggregate metrics such as total or average salary.

        Optional<Double> totalSalary = employees.stream().map(Employee::getSalary).reduce((s1, s2) -> s1 + s2);
        System.out.println(totalSalary.get());

        System.out.println("-------------");
        

    }
}
