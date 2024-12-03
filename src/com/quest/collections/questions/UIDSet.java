package com.quest.collections.questions;

import java.util.HashSet;
import java.util.Set;

public class UIDSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set1 = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set1.add(7);
        set1.add(6);
        set1.add(5);
        set1.add(4);
        set1.add(3);
        Set<Integer> union = new HashSet<>(set);
        union.addAll(set1);
        System.out.println("Union: " + union);

        System.out.println("Intersection:");
        for (Integer i : set) {
            if (set1.contains(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nDifference:");
        for (Integer i : set) {
            if (!set1.contains(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
