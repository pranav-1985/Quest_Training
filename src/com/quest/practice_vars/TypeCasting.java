package com.quest.practice_vars;

public class TypeCasting {
    public static void main(String[] args) {
        //implicit
        int n = 5;
        double d = n;
        System.out.println(d);

        //explicit
        double d1 = 9.78;
        int n1 = (int) d1;

        //explicit type casting
        System.out.println(n1);
        int n3 = 200;
        byte b = (byte) n3;
        //byte range is -128 to 128
        System.out.println(b);

    }
}
