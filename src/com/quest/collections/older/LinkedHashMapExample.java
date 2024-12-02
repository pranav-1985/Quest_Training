package com.quest.collections.older;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "one");
        linkedHashMap.put(2, "two");
        linkedHashMap.put(3, "three");
        linkedHashMap.put(4, "four");
        linkedHashMap.put(5, "five");
        linkedHashMap.put(6, "six");

        for (String s : linkedHashMap.values()) {
            System.out.println(s);
        }

        for (Integer key : linkedHashMap.keySet()) {
            System.out.println(key);
        }

        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println(linkedHashMap.get(6));
        System.out.println(linkedHashMap.remove(3));
        linkedHashMap.clear();
        System.out.println(linkedHashMap.isEmpty());

    }
}
