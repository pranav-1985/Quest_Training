package com.quest.oops.inheritence;

public class Student extends Person {
    private String schoolName;

    public Student(String name, int age, String schoolName) {
        super(name, age);
        this.schoolName = schoolName;
    }

    public void study() {
        System.out.println("Student study: " + this.name);

    }

    @Override
    public void nameDisplay() {
        super.nameDisplay();
        System.out.println("i study at " + this.schoolName);
    }
}

