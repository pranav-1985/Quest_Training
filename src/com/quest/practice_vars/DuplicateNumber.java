package com.quest.practice_vars;

public class DuplicateNumber {
    public static void main(String[] args) {

        int[] arr = {1, 4, 3, 54, 34, 33, 5, 4, 3, 4, 3};

        System.out.println("Duplicates in the array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i] + " has duplicates at index " + j);
                    break;
                }
            }
        }

    }
}
