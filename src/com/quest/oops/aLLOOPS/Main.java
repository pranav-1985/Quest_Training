package com.quest.oops.aLLOOPS;

public class Main {
    public static void main(String[] args) {

        Parent parent = new Parent(45);
        Child child = new Child(10);

        System.out.println(parent.toString());
        parent.work();
        System.out.println("--------");
        System.out.println(child.toString());
        child.work();

        System.out.println("----------");

        Parent parent1 = new Parent();
        System.out.println(parent1);
        System.out.println("--------");
        Child child1 = new Child();
        System.out.println(child1);

        //parent.name="parent1";
        //child.name="child 1"

    }

}
