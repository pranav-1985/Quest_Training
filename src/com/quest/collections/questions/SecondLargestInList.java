package com.quest.collections.questions;

import java.util.ArrayList;
import java.util.List;

public class SecondLargestInList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int largest = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > largest) {
                largest = list.get(i);
            }
        }
        int secondLargest = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > secondLargest && list.get(i) < largest) {
                secondLargest = list.get(i);
            }
        }
        System.out.println(secondLargest);
    }
}
