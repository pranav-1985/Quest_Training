package com.quest.collections.questions;

import java.util.HashSet;
import java.util.Set;

public class SetContainAll {
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<Integer>();
        Set<Integer> setB = new HashSet<Integer>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setB.add(1);
        setB.add(0);
        setB.add(3);
        setB.add(4);
        if (setA.containsAll(setB)) {
            System.out.println("Set contains all the elements");
        } else {
            System.out.println("Set does not contain all the elements");
        }
    }
}
