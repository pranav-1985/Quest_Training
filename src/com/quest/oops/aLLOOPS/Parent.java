package com.quest.oops.aLLOOPS;

public class Parent implements Person, Job {
    public final String name = "Parent";
    private int age;

    public Parent() {
        System.out.println("ageless parent");
    }

    public Parent(int age) {
        this.age = age;
    }

    @Override
    public void work() {
        System.out.println("parent job is to be a parent");
    }

    @Override
    public String name() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Parent [Name=" + name + ", Age=" + age + "]";
    }
}
