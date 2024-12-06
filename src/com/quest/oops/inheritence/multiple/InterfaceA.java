package com.quest.oops.inheritence.multiple;

public interface InterfaceA {
    void showMessage();


    static void staticMethod() {
        System.out.println("Static method in InterfaceA");
    }


    default void defaultMethod() {
        System.out.println("Default method in InterfaceA");
    }
}
