package com.quest.practiceQuestions;

public class LongestSubstring {
    public static void main(String[] args) {


        String[] arr = {"apple", "banana", "cherry", "watermelon", "kiwi"};

        String longestString = "";


        for (String str : arr) {
            if (str.length() > longestString.length()) {
                longestString = str;
            }
        }

        System.out.println("Longest string: " + longestString);
    }
}
