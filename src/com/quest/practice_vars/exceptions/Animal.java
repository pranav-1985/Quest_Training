package com.quest.practice_vars.exceptions;

import java.io.IOException;

public class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() throws IOException {
        System.out.println(name + " makes sound.");
    }

    public void displayInfo() {
        System.out.println("Animal Name: " + name);
    }

}
