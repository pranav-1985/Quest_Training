package com.quest.practice_vars;

import java.util.Scanner;

public class StudentMarks {
    public final static int MAX_SCORE = 100;

    static class Student {
        String name;
        int mathMarks;
        int englishMarks;
        int scienceMarks;
        int totalScore;
        int averageScore;
        String grade;
        String remark;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students : ");
        int numOfStudent = sc.nextInt();
        while (!isValidScore(numOfStudent)) {
            System.out.println("Invalid number of students, try again");
            numOfStudent = sc.nextInt();
        }
        for (int i = 1; i <= numOfStudent; i++) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter the name of student" + i + ": ");
            String name = sc1.nextLine();
            System.out.println("Enter the Math marks : ");
            int mathMark = sc1.nextInt();
            while (!isValidScore(mathMark)) {
                System.out.println("Invalid score, enter again");
                mathMark = sc1.nextInt();
            }
            System.out.println("Enter the english marks : ");
            int englishMark = sc1.nextInt();
            while (!isValidScore(englishMark)) {
                System.out.println("Invalid score, enter again");
                englishMark = sc1.nextInt();
            }
            System.out.println("Enter the science marks : ");
            int scienceMark = sc1.nextInt();
            while (!isValidScore(scienceMark)) {
                System.out.println("Invalid score, enter again");
                scienceMark = sc1.nextInt();
            }

            Student newStudent = new Student();
            newStudent.name = name;
            newStudent.mathMarks = mathMark;
            newStudent.englishMarks = englishMark;
            newStudent.scienceMarks = scienceMark;
            newStudent.totalScore = newStudent.englishMarks + newStudent.scienceMarks + newStudent.mathMarks;
            newStudent.averageScore = newStudent.totalScore / 3;

            if (newStudent.averageScore > 90) {
                newStudent.grade = "A";
                newStudent.remark = "Excellent Performance\n";
            } else if (newStudent.averageScore > 80) {
                newStudent.grade = "B";
                newStudent.remark = "Good job, but you can aim higher!\n";
            } else if (newStudent.averageScore > 70) {
                newStudent.grade = "C";
                newStudent.remark = "You need to put in more effort!\n";
            } else if (newStudent.averageScore > 60) {
                newStudent.grade = "D";
                newStudent.remark = "Your performance is below expectations. Consider seeking help.\n";
            } else if (newStudent.averageScore < 60) {
                newStudent.grade = "F";
                newStudent.remark = "Failure. You need significant improvement.\n Warning: Needs improvement in individual subjects.\n";
            }

            System.out.println("Total Score : " + newStudent.totalScore);
            System.out.println("Average : " + newStudent.averageScore);
            System.out.println("Grade : " + newStudent.grade);
            System.out.println(newStudent.remark);

        }
        System.out.println("Summary: " + numOfStudent + " students Processed");
    }

    public static boolean isValidScore(int score) {
        return score >= 0 && score <= MAX_SCORE;
    }
}
