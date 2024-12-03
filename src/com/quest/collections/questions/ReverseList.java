package com.quest.collections.questions;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}
