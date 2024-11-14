package com.quest.practice_vars;

public class CharCount {
    public static void main(String[] args) {
        String S = "mumbai";
        String[] words = S.split("");
        int[] count = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            
        }

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + "-" + count[i]);
        }
    }
}
