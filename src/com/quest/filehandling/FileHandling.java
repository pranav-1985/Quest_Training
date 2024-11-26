package com.quest.filehandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) throws IOException {

        File file = new File("FILE2.txt");

//        if (file.exists()) {
//            System.out.println("File exists " + file.getPath());
//        } else {
//            System.out.println("File not exists");
//        }

        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
        }


    }
}
