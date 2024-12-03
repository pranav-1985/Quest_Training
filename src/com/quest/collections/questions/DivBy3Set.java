package com.quest.collections.questions;

import java.util.HashSet;
import java.util.Set;

public class DivBy3Set {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.removeIf(x -> x % 3 == 0);
        System.out.println(set);
    }
}
