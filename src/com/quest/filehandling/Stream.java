package com.quest.filehandling;

import java.io.*;

public class Stream {
    public static void main(String[] args) {
        File file1 = new File("FILE4.txt");

        try {

            if (file1.exists() || file1.createNewFile()) {

                System.out.println("file created");

                FileInputStream fis = new FileInputStream(file1);
                int count;

                String str = "\nInput as Streams with creation using File\nokay\nhey\nwhere\nthere";

                FileOutputStream fos = new FileOutputStream(file1, true);
                fos.write(str.getBytes());
                while ((count = fis.read()) != -1) {
                    System.out.print((char) count);
                }
                fos.close();
                fis.close();
                System.out.println("\nfile closed");
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }


    }
}
