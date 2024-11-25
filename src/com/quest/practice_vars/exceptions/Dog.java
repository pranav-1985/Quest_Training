package com.quest.practice_vars.exceptions;

import java.io.IOException;

public class Dog extends Animal {

    private boolean hungry;

    public Dog(String name, boolean isHungry) {
        super(name);
        this.hungry = isHungry;
    }

    @Override
    public void makeSound() throws IOException {
        if (hungry) {
            super.makeSound();
            throw new IOException(name + " is hungry");

        } else {
            throw new IOException(name + " is not hungry.");
        }
    }

    public void calculateAge(int hYears) {
        if (hYears <= 0) {
            throw new ArithmeticException("Age cannot be zero or negative.");
        }
        int dogYears = hYears * 7;
        System.out.println(name + " is " + dogYears + " dog years old.");
    }
}

