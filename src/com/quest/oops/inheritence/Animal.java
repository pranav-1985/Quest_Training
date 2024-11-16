package com.quest.oops.inheritence;

public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void nameAnimal() {
        String msg = String.format("Animal is %s ", name);
        System.out.println(msg);
    }
}