package com.quest.memoryallocation;

import java.sql.SQLOutput;

public class Memory {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello world";

        String s3 = new String("hello");
        String s4 = new String("hello world");

        String s5 = s4;

//        check(s4, s3);

        check3(s1, s2);

        int i1 = 1;
        int i2 = 2;

//        check2(i1, i2);

    }

    public static void check(String s1, String s2) {
        if (s1 == s2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if (s1.equals(s2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if (s1.contains(s2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void check2(int i1, int i2) {
        if (i1 == i2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void check3(String s1, String s2) {
        if (s1.equals(s2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if (s2.contains("hello")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
