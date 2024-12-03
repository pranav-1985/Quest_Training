package com.quest.collections.questions;

import java.util.ArrayList;
import java.util.List;

public class EvenRemoveList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.removeIf(n -> n % 2 == 0);

        for (int i : list) {
            System.out.println(i);
        }
    }
}
