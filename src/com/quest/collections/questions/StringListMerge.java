package com.quest.collections.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringListMerge {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("Abc");
        list1.add("Def");
        list1.add("Ghi");
        list1.add("Jkl");
        list2.add("Def");
        list2.add("Ghi");
        list2.add("Jkl");
        list2.add("Klm");
        list2.add("Mno");

        Set<String> set1 = new HashSet<>();
        set1.addAll(list1);
        set1.addAll(list2);

        System.out.println(set1);
    }
}
