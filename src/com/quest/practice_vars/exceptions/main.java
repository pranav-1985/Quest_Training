package com.quest.practice_vars.exceptions;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        Dog dog1 = new Dog("Bro", true);
        Dog dog2 = new Dog("alpha", false);


        try {
            dog1.makeSound();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("-----------");

        try {
            dog2.calculateAge(-1);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            dog2.displayInfo();
        }

    }
}
