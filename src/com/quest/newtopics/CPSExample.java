package com.quest.newtopics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CPSExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        Predicate<Integer> predicate = x -> x % 2 == 0;

        List<Integer> newList = new ArrayList<>();
        for (Integer i : list) {
            if (predicate.test(i)) {
                newList.add(i);
            }
        }

        Consumer<List<Integer>> consumer = (list1) -> {
            for (int i = 0; i < list1.size(); i++) {
                list1.set(i, list1.get(i) * 2);
            }
        };


        consumer.accept(newList);

        Supplier<List<Integer>> supplier = () -> newList;

        System.out.println(supplier.get());
    }
}
