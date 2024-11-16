package com.quest.oops.inheritence;

public class Cat extends Animal {
    private String sound = "meowww";

    public Cat(String name) {
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
