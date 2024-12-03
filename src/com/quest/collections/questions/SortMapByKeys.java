package com.quest.collections.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByKeys {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 0);
        map.put("f", 6);
        map.put("d", 3);
        map.put("b", 2);
        map.put("e", 9);
        map.put("c", 2);
        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);
        System.out.println(sortedMap);

    }
}
