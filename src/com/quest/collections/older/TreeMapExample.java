package com.quest.collections.older;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {

        TreeMap<String, String> map = new TreeMap<>();
        map.put("A", "B");
        map.put("C", "D");
        map.put("E", "F");
        map.put("G", "H");
        map.put("I", "J");
        map.put("K", "L");
        map.put("M", "N");

        map.forEach((key, value) -> System.out.println(key + ":" + value));

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "alpha");
        treeMap.put(2, "beta");
        treeMap.put(3, "gamma");
        treeMap.put(4, "delta");
        treeMap.put(5, "epsilon");
        treeMap.put(6, "zeta");

        TreeMap<Double, Boolean> doubleBooleanMap = new TreeMap<>();
        doubleBooleanMap.put(1.1, true);
        doubleBooleanMap.put(2.2, false);
        doubleBooleanMap.put(3.3, true);
        doubleBooleanMap.put(4.4, false);
        doubleBooleanMap.forEach((key, value) -> System.out.println(key + ":" + value));

        TreeMap<Boolean, String> booleanStringMap = new TreeMap<>();
        booleanStringMap.put(true, "Yes");
        booleanStringMap.put(false, "No");
        booleanStringMap.forEach((key, value) -> System.out.println(key + ":" + value));

        TreeMap<Float, Character> floatCharMap = new TreeMap<>();
        floatCharMap.put(1.1f, 'A');
        floatCharMap.put(2.2f, 'B');
        floatCharMap.put(3.3f, 'C');
        floatCharMap.put(4.4f, 'D');
        floatCharMap.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
