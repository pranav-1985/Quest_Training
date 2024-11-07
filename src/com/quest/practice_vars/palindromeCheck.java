package com.quest.practice_vars;

import java.util.Scanner;

public class palindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        if (s == null) {
            System.out.println("Empty string");
            return;
        }
        StringBuilder sb = new StringBuilder(s);
        StringBuilder reverse = sb.reverse();
        String reversedString = reverse.toString();

        if (s.equals(reversedString)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}
