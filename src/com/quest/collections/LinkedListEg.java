package com.quest.collections;

import java.util.LinkedList;

public class LinkedListEg {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("Alpha");
        list.add("Beta");
        list.add("Charlie");
        list.add("Delta");
        list.add("Echo");

        list.add(5, "Foxtrot");

        list.addFirst("Adam");

        list.addLast("Gamma");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("------------");

        list.removeFirst();
        list.removeLast();
        System.out.println(list.reversed());

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());

    }
}
