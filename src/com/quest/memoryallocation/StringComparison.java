package com.quest.memoryallocation;

public class StringComparison {

    public static void main(String[] args) {
        stringEqual();
        stringBuilderEqual();
        stringBufferEqual();
        StringBuilderMethods();
        StringBufferMethods();
    }


    public static void stringEqual() {


        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");


        System.out.println((str1 == str2));
        System.out.println((str1 == str3));


        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println();
    }


    public static void stringBuilderEqual() {


        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");


        System.out.println(sb1 == sb2);


        System.out.println(sb1.equals(sb2));
        System.out.println(
                sb1.toString().equals(sb2.toString()));
        System.out.println();
    }


    public static void stringBufferEqual() {


        StringBuffer sb1 = new StringBuffer("Hello");
        StringBuffer sb2 = new StringBuffer("Hello");


        System.out.println(sb1 == sb2);


        System.out.println(sb1.equals(sb2));
        System.out.println(
                sb1.toString().equals(sb2.toString()));
    }


    public static void StringBuilderMethods() {


        StringBuilder sb = new StringBuilder("Java");

        sb.append(" Programming");
        System.out.println(sb);

        sb.insert(4, " Language");
        System.out.println(sb);

        sb.replace(4, 11, "Script");
        System.out.println(sb);

        sb.delete(11, 24);
        System.out.println(sb);


        sb.reverse();
        System.out.println(sb);

    }


    public static void StringBufferMethods() {

        String s = "hello";
        StringBuffer sb = new StringBuffer(s);

        sb.append(" World");
        System.out.println(sb);

        sb.insert(5, ",");
        System.out.println(sb);

        sb.replace(7, 12, "Java");
        System.out.println(sb);

        sb.delete(5, 6);
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

    }
}
