package com.quest.practice_vars;

public class StudentScores {
    public static void main(String[] args) {
        // Step 1: Initialize arrays
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace"};
        int[] ages = {20, 21, 22, 23, 24, 25, 26};
        int[][] scores = {
                {85, 90, 78, 92, -1},
                {88, 92, 80, -1, 85},
                {75, 80, 70, 60, 72},
                {90, 85, 88, 95, 92},
                {65, 70, 60, 68, 67},
                {80, 85, -1, 90, 95},
                {90, 88, 92, 85, 80}
        };
        double[] avgScores = new double[names.length];

        // Step 2: Calculate average scores
        calculateAverageScores(names, ages, scores, avgScores);

        // Step 3: Find the highest scorer
        findHighestScorer(names, ages, scores, avgScores);

        // Step 4: Ranking students by average score
        rankStudents(names, ages, scores, avgScores);

        // Step 5: Detect missing data
        detectMissingData(names, scores);
    }

    public static void calculateAverageScores(String[] names, int[] ages, int[][] scores, double[] avgScores) {
        // Logic to calculate and print average scores for each student
        for (int i = 0; i < scores.length; i++) {
            int sum = 0;
            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[i][j];
            }

            avgScores[i] = (double) sum / scores[i].length;
            System.out.println(names[i] + " average score: " + avgScores[i]);
        }
    }

    // Method to find the student with the highest average score
    public static void findHighestScorer(String[] names, int[] ages, int[][] scores, double[] avgScores) {
        // Logic to find and print the student with the highest average score
        double maxAvg = 0.00;
        String maxScorer = "";
        for (int i = 0; i < avgScores.length; i++) {
            if (avgScores[i] > maxAvg) {
                maxAvg = avgScores[i];
                maxScorer = names[i];
            }
        }
        System.out.println("\n------------------------------\n");
        System.out.println("highest average scorer is " + maxScorer + " with " + maxAvg + " mark");
    }

    // Method to rank students based on average score
    public static void rankStudents(String[] names, int[] ages, int[][] scores, double[] avgScores) {

        class Student {
            String sName;
            double averageScore;

            public Student(String name, double averageScore) {
                this.sName = name;
                this.averageScore = averageScore;
            }

            public String getsName() {
                return this.sName;
            }

            public double getAverageScore() {
                return this.averageScore;
            }
        }
        Student[] students = new Student[names.length];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(names[i], avgScores[i]);
        }
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].getAverageScore() < students[j + 1].getAverageScore()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("--------------");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getsName() + " with avg mark " + students[i].getAverageScore() + " has rank " + (i + 1));
        }

    }

    // Method to detect missing data in the scores array
    public static void detectMissingData(String[] names, int[][] scores) {
        System.out.println("----------Missing student data--------\n");
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                if (scores[i][j] == -1) {
                    System.out.println(names[i] + " has a missing score for subject " + (j + 1));
                }
            }
        }

    }

}
