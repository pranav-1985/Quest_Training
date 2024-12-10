package com.quest.collections_pending;

import java.io.*;
import java.util.List;

public class SerializationExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Employee employee1 = new Employee("Nikhil1", 30, 101);
        Employee employee2 = new Employee("Nikhil2", 31, 102);
        Employee employee3 = new Employee("Nikhil3", 32, 103);

        List<Employee> employee11 = List.of(employee1, employee2, employee3);

        FileOutputStream fileOutputStream = new FileOutputStream("employee.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employee11);

        FileInputStream fileInputStream = new FileInputStream("employee.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Employee> employeeList = (List<Employee>) objectInputStream.readObject();
        System.out.println(employeeList);

    }
}
