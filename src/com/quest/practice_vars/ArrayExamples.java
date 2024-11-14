package com.quest.practice_vars;

public class ArrayExamples {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i : arr) {
            System.out.println(i);
        }

        int[][] arr2 = new int[3][3];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = i;
            }
        }
        System.out.println("--");
        for (int[] n : arr2) {
            for (int x : n) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        System.out.println("------------\n");
        /*
        create a method to search a int value from the int[] array.
        Method should accept both int[] and int to search and
        return the index of the value to search.
        If the value is not found , return -1
         */
        int[] array = {5, 3, 4, 1, 2};
        int value = 3;

        ArrayExamples searchIndex = new ArrayExamples();
        int index = searchIndex.search(array, value);
        System.out.println("Index of " + value + ": " + index);

        /*
        create a method that accepts the int[] array,sort this
        int[] array and return the new sorted array or same array
        if you sorted the same array in place. and finally print the
        sorted array in the new method with the name
        printArray(int[] arr)
         */

        ArrayExamples sortArray = new ArrayExamples();
        int[] sortedArray = sortArray.sort(array);
        sortArray.printArray(sortedArray);

    }

    private int search(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i; // Return the index if the value is found
            }
        }
        return -1; // Return -1 if the value is not found
    }

    private int[] sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    private void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println(); // Move to next line after printing the array
    }
}
