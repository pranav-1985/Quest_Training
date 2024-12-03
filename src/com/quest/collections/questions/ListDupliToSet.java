package com.quest.collections.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListDupliToSet {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Abc");
        list.add("Abc");
        list.add("Def");
        list.add("Def");
        list.add("Ghi");
        list.add("Ghi");
        Set<String> set = new HashSet<String>();
        set.addAll(list);
        System.out.println(set);
    }
}
