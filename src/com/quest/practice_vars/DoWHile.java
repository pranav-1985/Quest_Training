package com.quest.practice_vars;

public class DoWhile {
    public static void main(String[] args) {
        int count = 0;
        System.out.println("before counting=>" + count);
        do {
            count++;
            System.out.println("Count is: " + count);

        } while (count <= 5);

        System.out.println("after counting=>" + count);

    }
}
