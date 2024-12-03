package com.quest.collections.questions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindDupliSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int[] arr = {1, 2, 3, 4, 1, 3, 8, 4, 9};
        for (int i = 0; i < arr.length; i++) {
            Scanner sc = new Scanner(System.in);
            if (set.add(arr[i])) {
                System.out.println(arr[i] + "inserted");
            } else {
                System.out.println(arr[i] + "is duplicate");
                break;
            }
        }
    }
}
