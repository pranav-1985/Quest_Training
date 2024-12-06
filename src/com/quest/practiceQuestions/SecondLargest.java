package com.quest.practiceQuestions;

public class SecondLargest {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 100, 8, 9};

        int largest = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        System.out.println("largest : " + largest);

        int secondLargest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("Second largest : " + secondLargest);
    }
}
