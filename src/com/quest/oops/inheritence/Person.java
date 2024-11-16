package com.quest.oops.inheritence;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void nameDisplay() {
        String msg = String.format("student name is %s & age is %d", name, age);
        System.out.println(this.name);
        System.out.println(msg);
    }
}
