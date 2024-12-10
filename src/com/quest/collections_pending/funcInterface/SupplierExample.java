package com.quest.collections_pending.funcInterface;

import com.quest.collections_pending.Employee;

import java.util.function.Supplier;

public class SupplierExample {


    public static void main(String[] args) {

        Supplier<Employee> employeeSupplier = () -> {
            //get some evaluation or condition check around data
            // return a new emplooyee
            return new Employee("Nikhil", 12, 100);
        };

        Employee employee = employeeSupplier.get();
        System.out.println(employee);

    }
}
