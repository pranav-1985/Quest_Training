package com.quest.practiceQuestions;

import java.io.*;
import java.util.Scanner;

public class FindStringInFile {
    public static void main(String[] args) throws IOException {

        String searchString = "Java";


        FileWriter writer = new FileWriter("example.txt");
        writer.write("Hello, this is a Java program.\nJava is powerful.");
        writer.close();

        Scanner scanner = new Scanner(new File("example.txt"));
        boolean found = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(searchString)) {
                found = true;
                break;
            }
        }
        scanner.close();

        if (found) {
            System.out.println("String \"" + searchString + "\" found ");
        } else {
            System.out.println("String \"" + searchString + "\" not found");
        }
    }
}