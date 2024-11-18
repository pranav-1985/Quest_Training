package com.quest.practice_vars;

public class PracticeOperators {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        //arithametic operators
        System.out.println(a + b);
        System.out.println(a * b);
        System.out.println(b % a);
        System.out.println(b / a);
        System.out.println(a - b);
        System.out.println(b - a);

        //relational operators
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a < b);
        System.out.println(a > b);
        System.out.println(a <= b);
        System.out.println(a >= b);

        //boolean
        boolean x = true;
        boolean y = false;

        //logical
        System.out.println(x && y);
        System.out.println(x || y);
        System.out.println(x != y);

        int z = 10;
        //assignment
        z += 5;//z=z+5
        System.out.println(z);

        //unary operators
        System.out.println(z++);
        System.out.println(z);
        System.out.println(++z);
        System.out.println(z--);
        System.out.println(z);
        System.out.println(--z);
        System.out.println(z);


        int p = 17;
        int q = 5;
        //ternary operators
        int result = p > 15 ? q++ : 0;
        System.out.println(result);
        System.out.println(q);
    }
}

