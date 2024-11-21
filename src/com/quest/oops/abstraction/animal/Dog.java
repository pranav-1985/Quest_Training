package com.quest.oops.abstraction.animal;

public class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("dog sound is woof");
    }

    @Override
    public void name() {
        System.out.println("dog name is Jeff");
    }
}
