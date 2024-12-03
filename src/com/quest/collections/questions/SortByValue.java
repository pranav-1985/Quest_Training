package com.quest.collections.questions;

import java.util.*;

public class SortByValue {
    public static void main(String[] args) {
        Map<Student, Integer> studentMap = new HashMap<>();
        studentMap.put(new Student("Alice", 101), 85);
        studentMap.put(new Student("Bob", 102), 92);
        studentMap.put(new Student("Charlie", 103), 78);


        List<Map.Entry<Student, Integer>> entryList = new ArrayList<>(studentMap.entrySet());


        Collections.sort(entryList, Map.Entry.comparingByValue());

        Map<Student, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<Student, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        
        for (Map.Entry<Student, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
