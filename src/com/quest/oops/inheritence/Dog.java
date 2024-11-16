package com.quest.oops.inheritence;

public class Dog extends Animal {
    private String sound = "bowwwwwww";

    public Dog(String name) {
        super(name);
    }

    public void getSound() {
        System.out.println("sound is " + sound);
    }

    @Override
    public void nameAnimal() {
        super.nameAnimal();
        getSound();
    }
}
