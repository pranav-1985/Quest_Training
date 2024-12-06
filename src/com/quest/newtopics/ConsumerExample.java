package com.quest.newtopics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ConsumerExample {
    public static void main(String[] args) {

        List<String> studentNames = new ArrayList<>();
        studentNames.add("John");
        studentNames.add("Jane");
        studentNames.add("Bob");
        studentNames.add("Mary Poppins");


        Consumer<String> printUpperCase = (name) -> {
            System.out.println(name.toUpperCase());
        };


        Consumer<String> printLength = (name) -> {
            System.out.println("Length: " + name.length());
        };

        Predicate<String> isLengthGreater = (name) -> name.length() > 5;

        Supplier<List<String>> getNames = () -> studentNames;


        studentNames.forEach(name -> {
            printUpperCase.accept(name);
            printLength.accept(name);
            System.out.println(isLengthGreater.test(name));
            System.out.println(getNames.get());
        });
    }
}
