package com.quest.filehandling;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("FILE1.txt");
            System.out.println("file created");
            int count;
            String str = "Input as Streams";
            FileOutputStream fos = new FileOutputStream("FILE1.txt");
            fos.write(str.getBytes());
            while ((count = fis.read()) != -1) {
                System.out.println((char) count);
            }
            fos.close();
            fis.close();
            System.out.println("file closed");
            
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }


    }
}
