package com.quest.oops.interfaces;

public interface vehicle {
    void startEngine();

    void stopEngine();


    default void honk() {
        System.out.println("This is a Vehicle!");
    }
}
