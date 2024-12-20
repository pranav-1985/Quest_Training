package com.quest.test2.questionset2;

import java.util.*;

public class GroupbyFrequency {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        Map<Integer, List<Integer>> map = new TreeMap<>(groupByFrequency(list));
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static Map<Integer, List<Integer>> groupByFrequency(List<Integer> list) {

        Map<Integer, Integer> map = new TreeMap<>();

        for (int num : list) {// to map numbers and their frequency <number,frequency>
            if (!map.containsKey(num)) {
                map.put(num, 1);//if num not in map put num and frequency as 1
            } else {
                map.put(num, map.get(num) + 1); //add 1 to frequency everytime if reappears
            }
        }

        Map<Integer, List<Integer>> frequencyMap = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            if (!frequencyMap.containsKey(entry.getValue())) {//checks if frequency is already there if not puts frequency and a new arraylist into the map
                List<Integer> list1 = new ArrayList<>();
                list1.add(entry.getKey());
                frequencyMap.put(entry.getValue(), list1);
            } else {
                frequencyMap.get(entry.getValue()).add(entry.getKey());//if frequency present just adds the number to the value list
            }
        }

        return frequencyMap;
    }
}
