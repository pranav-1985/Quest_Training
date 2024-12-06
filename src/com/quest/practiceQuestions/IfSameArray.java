package com.quest.practiceQuestions;

public class IfSameArray {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i;
            array2[i] = i + 1;
        }
        boolean isSame = true;
        for (int i = 0; i < array1.length; i++) {
            if (!(array1[i] == array2[i])) {
                isSame = false;
            }
        }
        if (isSame) {
            System.out.println("Arrays are same");
        } else {
            System.out.println("Arrays are different");
        }
    }
}
