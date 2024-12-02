package com.quest.collections.streams;

import java.util.ArrayList;
import java.util.Optional;

public class StreamExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(9);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list.stream().findFirst());
//        ArrayList<Integer> list2 = list.stream().findFirst();

        System.out.println(list.stream().max(Integer::compareTo).get());
        System.out.println(list.stream().min(Integer::compareTo).get());

        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println(max.get());
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        System.out.println(min.get());

        System.out.println(list.stream().sorted().toList());

    }
}
