package com.quest.practice_vars;

public class StringMethods {
    public static void main(String[] args) {

        String str = "Hello, Java World!";
        String str2 = "Hello, java world!";

        // Length
        System.out.println("Length of str: " + str.length());
        //character find
        System.out.println("Character at index 7: " + str.charAt(7));

        // Case Conversion
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("Uppercase: " + str.toUpperCase());

        // Comparison
        System.out.println("Equals str2: " + str.equals(str2)); //false
        System.out.println("Equals (ignore case) str2: " + str.equalsIgnoreCase(str2));  //true...it ignores case

        System.out.println("Starts with 'Hello': " + str.startsWith("Hello"));
        System.out.println("Ends with 'World!': " + str.endsWith("World!"));

        // Searching
        System.out.println("Index of 'Java': " + str.indexOf("Java")); // starting index of java
        System.out.println("Last index of 'o': " + str.lastIndexOf("o")); //last known index of o
        System.out.println("Contains 'Java': " + str.contains("Java")); //whether string contains java

        // Substring and Splitting
        System.out.println("Substring from index 7: " + str.substring(7)); //substring from 7th to last index
        System.out.println("Substring from 7 to 11: " + str.substring(7, 11)); //substring from 7-11th index
        String[] words = str.split(" "); //splits the string when a space is occured
        System.out.println("Splitting by space:");
        for (String word : words) {
            System.out.println(word);
        }

        // Whitespace Trimming
        String strWithSpaces = "   Hello, Java!   ";
        System.out.println("Trimmed: '" + strWithSpaces.trim() + "'"); //trim() gets rid of spaces

        // Replacement
        System.out.println(str.replace("Java", "Python"));   //replace(target,replacement item)
        System.out.println("Replace all 'l' with '*': " + str.replaceAll("l", "*")); //replaces every l with *

        // Concatenation
        System.out.println(str.concat(" Enjoy coding!")); //concats new string to existing one

        // Conversion
        int num = 123;
        System.out.println("String value of 123: " + String.valueOf(num)); //finds string value
        char[] charArray = str.toCharArray(); //converts string to char array
        System.out.println("Character array:");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        // Pattern Matching
        String pattern = ".*Java.*"; //anything before and after java(.*)
        System.out.println(str.matches(pattern));
    }
}

