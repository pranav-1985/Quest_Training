package com.quest.collections_pending.streams;

import com.quest.collections_pending.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String[] args) {

        Employee employee1 = new Employee("name1", 20, 101);
        Employee employee2 = new Employee("name2", 20, 102);
        Employee employee3 = new Employee("name3", 20, 103);
        Employee employee4 = new Employee("name4", 20, 104);
        Employee employee5 = new Employee("name5", 20, 105);

        List<Employee> employeelist = List.of(employee1, employee2, employee3, employee4, employee5);
        employeelist
                .stream()
                .peek(e -> System.out.println(e))
                .filter(e1 -> e1.getSalary() > 101)
                .toList();



    }


}
