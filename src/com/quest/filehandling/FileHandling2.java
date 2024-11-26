package com.quest.filehandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandling2 {
    public static void main(String[] args) {

        try {
            FileWriter fw = new FileWriter("FileWriter1.txt");
            fw.write("Hello World file writer try 1");
            fw.append("@charsqindextry", 0, 15);
            fw.close();
            System.out.println("file created successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
