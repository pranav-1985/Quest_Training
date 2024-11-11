package com.quest.practice_vars;

public class DataTypes {
    public static void main(String[] args) {
        // Integer type
        int intValue = 10;
        System.out.println("Integer Value: " + intValue);

        // Float type
        float floatValue = 3.14f;
        System.out.println("Float Value: " + floatValue);

        // Double type
        double doubleValue = 3.14159;
        System.out.println("Double Value: " + doubleValue);

        // Char type
        char charValue = 'A';
        System.out.println("Char Value: " + charValue);

        // Boolean type
        boolean booleanValue = true;
        System.out.println("Boolean Value: " + booleanValue);

        // String (reference type)
        String stringValue = "Hello, Java!";
        System.out.println("String Value: " + stringValue);

        // Array (reference type)
        int[] intArray = {1, 2, 3, 4, 5};
        System.out.print("Array Values: ");
        for (int num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Class example (reference type)
        Person person = new Person("Alice", 25);
        System.out.println("Person Name: " + person.name + ", Age: " + person.age);
    }

    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
