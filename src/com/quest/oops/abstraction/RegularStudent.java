package com.quest.oops.abstraction;

public class RegularStudent extends Student {

    @Override
    public void attendClass() {
        System.out.println("attending online and offline classes");
    }

    @Override
    public void submitAssignment() {
        System.out.println("regular student submitting the assignment");
    }
}
