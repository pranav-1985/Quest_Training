package com.quest.practice_vars;

public class TwoDArray {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 9}, {4, 5, 6, 8}, {7, 8, 9, 7}};
//        int n = 0;
//        for (int[] arr : array) {
//            for (int i = 0; i < arr.length / 2; i++) {
//                int temp = arr[i];
//                arr[i] = arr[arr.length - i - 1];
//                arr[arr.length - i - 1] = temp;
//            }
//        }
        for (int[] arr : array) {
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print((arr[i]));
            }
            System.out.println();
        }

    }
}
