package com.quest.oops.test1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        int[] arr = {2, 4, 10, 5, 6, 7, 8, 9, 2, 1};

        int largest = arr[0];
        int secondLargest = arr[0];

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
    }
}
