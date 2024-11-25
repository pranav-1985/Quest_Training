package com.quest.practice_vars.exceptions.customexception;

public class Manager extends Employee {
    private Integer teamSizeObject;

    public Manager(String name, int age, double salary, int teamSize) throws InvalidInputException, IllegalArgumentException {
        super(name, age, salary);
        if (teamSize < 0) {
            throw new IllegalArgumentException("Team size must be greater than 0");
        }
        this.teamSizeObject = teamSize;
    }

    public int getTeamSize() {
        int teamSize = teamSizeObject;
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSizeObject = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + getTeamSize());
    }
}
