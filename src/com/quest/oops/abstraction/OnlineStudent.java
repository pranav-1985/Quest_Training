package com.quest.oops.abstraction;

public class OnlineStudent extends Student {

    public OnlineStudent() {
        System.out.println("creating Online Student");
    }

    @Override
    public void attendClass() {
        System.out.println(" Online student Attending Class");
    }

    @Override
    public void submitAssignment() {
        System.out.println(" Online student Submit Assignment");
    }
}
