package com.quest.collections.older;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> h = new HashMap<>();
        h.put(1, "A");
        h.put(4, "F");
        h.put(5, "E");
        h.put(2, "D");
        h.put(3, "C");
        h.put(6, "B");
        for (String s : h.values()) {
            System.out.println(s);
        }
        for (Integer i : h.keySet()) {
            System.out.println(i);
        }

        for (Map.Entry<Integer, String> entry : h.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println(h.get(6));
        System.out.println(h.remove(3));
        h.clear();
        System.out.println(h.isEmpty());
    }
}
