package com.quest.practice_vars;

public class FIndMissingInPattern {
    public static void main(String[] args) {

        int[] array = {1, 3, 7, 9, 11, 17};

        int[] missingNumbers = new int[array.length - 1];
        int miss = 0;

        for (int i = 0; i < array.length - 1; i++) {

            int first = array[i];
            int second = array[i + 1];

            while (second - first > 2) {
                first += 2;
                missingNumbers[miss] = first;
                miss++;
            }
        }

        System.out.print("Missing Numbers: ");
        for (int i = 0; i < miss; i++) {
            System.out.print(missingNumbers[i] + " ");
        }
    }
}

