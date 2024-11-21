package com.quest.oops.aLLOOPS;

public class Child implements Person, Job {

    private final String name = "Child";
    private int age;

    public Child() {
        System.out.println("ageless child");
    }

    public Child(int age) {
        this.age = age;
    }

    @Override
    public void work() {
        System.out.println("I am child and its my job");
    }

    @Override
    public String name() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

}
