package com.quest.collections.older;

import java.util.TreeSet;

public class TreeHashSetExample {
    public static void main(String[] args) {

        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);

        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
        System.out.println("----------");

        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.size());
        System.out.println("--------------");
        System.out.println(treeSet.descendingSet());
        System.out.println("--------------");
        System.out.println(treeSet.headSet(5, true));
        System.out.println("------------");
        System.out.println(treeSet.tailSet(3, true));
        System.out.println("--------------");
        System.out.println(treeSet.reversed());
        System.out.println("--------------");


    }
}
