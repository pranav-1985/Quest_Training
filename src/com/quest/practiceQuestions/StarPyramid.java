package com.quest.practiceQuestions;

public class StarPyramid {
    public static void main(String[] args) {

        int size = 4;
        for (int i = 0; i <= size; i++) {
            for (int k = size; k > i; k--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();

        }

    }
}
