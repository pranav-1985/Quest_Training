package com.quest.oops.abstraction.animal;

public class Bird extends Animal {

    @Override
    public void sound() {
        System.out.println("bird sound is chirp");
    }

    @Override
    public void name() {
        System.out.println("bird name is Kingfisher");
    }
}
