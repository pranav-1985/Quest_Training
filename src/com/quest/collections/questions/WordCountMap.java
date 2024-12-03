package com.quest.collections.questions;

import java.util.HashMap;
import java.util.Map;

public class WordCountMap {
    public static void main(String[] args) {

        Map<String, Integer> wordCountMap = new HashMap<String, Integer>();

        String str = "Java is fun and java is powerful";

        str = str.toLowerCase();

        String[] words = str.split(" ");

        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        for (String word : wordCountMap.keySet()) {
            System.out.println(word + " : " + wordCountMap.get(word));
        }

    }
}
