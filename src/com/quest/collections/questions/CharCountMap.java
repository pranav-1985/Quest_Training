package com.quest.collections.questions;

import java.util.HashMap;
import java.util.Map;

public class CharCountMap {
    public static void main(String[] args) {
        Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        String str = "Hello World";
        str = str.toLowerCase();
        str = str.replace(" ", "");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        System.out.println(charCountMap);
    }
}
