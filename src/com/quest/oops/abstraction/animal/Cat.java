package com.quest.oops.abstraction.animal;

public class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("cat sound is meow");
    }

    @Override
    public void name() {
        System.out.println("cat name is Whiskers");
    }
}
