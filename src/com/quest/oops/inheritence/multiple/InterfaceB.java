package com.quest.oops.inheritence.multiple;

public interface InterfaceB {
    void showMessage();


    static void staticMethod() {
        System.out.println("Static method in InterfaceB");
    }


    default void defaultMethod() {
        System.out.println("Default method in InterfaceB");
    }
}