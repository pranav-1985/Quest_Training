package com.quest.practice_vars;

import java.util.Scanner;

public class NumberPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int n = num;
        int temp = 0;
        while (num != 0) {
            int ld = num % 10;
            temp = temp * 10 + ld;
            num = num / 10;
        }
        if (temp == n) {
            System.out.println(n + " is a palindrome");
        } else {
            System.out.println(n + " is not a palindrome");
        }
    }
}
