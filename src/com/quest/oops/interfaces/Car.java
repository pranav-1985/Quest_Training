package com.quest.oops.interfaces;

public class Car implements vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car starts engine");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car stops engine");
    }


}
