package com.quest.collections.older;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {

        Vector<Integer> v = new Vector<>();

        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.add(5);

        System.out.println(v.get(3));
        System.out.println(v.size());
        v.add(5);
        System.out.println(v);
        System.out.println(v.contains(3));
        System.out.println(v.isEmpty());
        System.out.println(v.remove(3));


    }
}
