package com.quest.collections.older;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> h = new HashSet<>();
        h.add(1);
        h.add(2);
        h.add(3);
        for (int i : h) {
            System.out.println(i);
        }
        System.out.println("-----------");
        h.add(null);
        for (Integer i : h) {
            System.out.println(i);
        }

    }
}
