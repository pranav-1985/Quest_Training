package com.quest.practice_vars;

public class CharCount {
    public static void main(String[] args) {
        String S = "mumbai";
        String[] words = S.split("");
        int[] count = new int[words.length];

        // Initialize counts for each character
        for (int i = 0; i < words.length; i++) {
            count[i] = 1; // Initialize count for the current character
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count[i]++;
                    words[j] = ""; // Avoid counting the same character again by making it null
                }
            }
        }

        // Display the character counts
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) { // Print only non-empty/not null characters
                System.out.println(words[i] + "-" + count[i]);
            }
        }
    }
}
