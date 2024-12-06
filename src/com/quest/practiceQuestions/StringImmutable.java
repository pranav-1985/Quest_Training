package com.quest.practiceQuestions;

public class StringImmutable {
    public static void main(String[] args) {

        String str = "Hello";


        int originalHashCode = str.hashCode();


        String newStr = str.concat(" World");

        str = str + newStr;

        int newHashCode = str.hashCode();


        System.out.println("Original String: " + str);
        System.out.println("Hash Code of Original String: " + originalHashCode);

        System.out.println("Modified String: " + newStr);
        System.out.println("Hash Code of Modified String: " + newHashCode);

    }
}
