package com.quest.collections.questions;

import java.util.ArrayList;
import java.util.List;

public class IntOccurList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(2);
        list.add(5);
        int count = 0;
        List<Integer> list2 = new ArrayList<>();
        for (int i : list) {
            if (!list2.contains(i)) {
                for (int j : list) {
                    if (i == j) {
                        count++;
                        list2.add(i);
                    }
                }
                System.out.println(i + " : " + count);
                count = 0;
            }
        }


    }
}
