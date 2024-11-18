package com.quest.practice_vars;

import java.util.Scanner;

public class FibonnaciSeries {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        number = sc.nextInt();
        System.out.println("The fibonnaci series is: ");

        int first = 0, second = 1;
        System.out.println("Fibonacci series using iteration:");
        for (int i = 0; i < number; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }

    }
}
