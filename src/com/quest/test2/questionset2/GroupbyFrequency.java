package com.quest.test2.questionset2;

import java.util.*;

public class GroupbyFrequency {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(3);
        Map<Integer, List<Integer>> map = new TreeMap<>(groupByFrequency(list));
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static Map<Integer, List<Integer>> groupByFrequency(List<Integer> list) {

        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : list) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        Map<Integer, List<Integer>> freqMap = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int number = entry.getKey();
            int frequency = entry.getValue();


            if (!freqMap.containsKey(frequency)) {
                List<Integer> list1 = new ArrayList<>();
                freqMap.put(frequency, list1);
            } else {
                freqMap.get(frequency).add(number);
            }
        }

        return freqMap;
    }
}
