package com.quest.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling3 {
    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("EXAMPLE.txt");
        try {

            if (file1.exists() || file1.createNewFile()) {

                System.out.println("file created");
            }

            FileWriter fw = new FileWriter(file1);
            fw.write("Hello World");
            fw.close();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            Scanner sc = new Scanner(file1);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();

            file1.delete();

            System.out.println("file deleted");

        }
    }
}
