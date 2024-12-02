package com.quest.collections.older;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CollectionTest {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        while (hs.size() < 100) {
            int num = (int) (Math.random() * 100);
            hs.add(num);
        }
        hs.add(null);
        hs.add(null);
        hs.add(null);
        System.out.println("-----HashSet------");
        for (Integer i : hs) {
            System.out.print(i + ",");
        }

        LinkedHashSet<Integer> ls = new LinkedHashSet<>();
        while (ls.size() < 100) {
            int num = (int) (Math.random() * 100);
            ls.add(num);
        }
        ls.add(null);
        ls.add(null);
        ls.add(null);
        System.out.println("\n-----LinkedHashSet------");
        for (Integer i : ls) {
            System.out.print(i + ",");
        }


        TreeSet<Integer> ts = new TreeSet<>();
        while (ts.size() < 100) {
            int num = (int) (Math.random() * 100);
            ts.add(num);
        }
        ls.add(null);
        ls.add(null);
        ls.add(null);
        System.out.println("\n-----TreeSet------");
        for (Integer i : ts) {
            System.out.print(i + ",");
        }

    }

}
