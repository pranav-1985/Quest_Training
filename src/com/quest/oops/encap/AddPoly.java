package com.quest.oops.encap;

public class AddPoly {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double add(int a, double b) {
        return a + b;
    }

    public Integer add(Integer a, Integer b) {
        return Integer.valueOf(a + b);  // Wrapping result in Integer
    }

    public Integer add(Object a, Object b) {
        return Integer.valueOf(a + b.toString());
    }
}
