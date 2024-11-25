package com.quest.practice_vars.exceptions.customexception;

public class StackOverFlowOutOfMemory {

    public static void causeStackOverflowError() {
        causeStackOverflowError();
    }

    public static void causeOutOfMemory() {
        try {
            int[] largeArray = new int[Integer.MAX_VALUE];
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError caught: " + e);
        }
    }

    public static void main(String[] args) {
        try {
            causeStackOverflowError();
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError caught: " + e);
        }

        causeOutOfMemory();
    }
}
