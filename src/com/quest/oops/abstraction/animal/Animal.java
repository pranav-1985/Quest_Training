package com.quest.oops.abstraction.animal;

public abstract class Animal {

    public abstract void name();

    public abstract void sound();

    public void eat() {
        System.out.println("Animal eats");
    }
    
}
