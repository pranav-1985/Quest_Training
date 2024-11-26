package com.quest.filehandling;

import java.io.*;

public class BufferedClass {
    public static void main(String[] args) {
        String str = "Hello World";
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("FILE1.txt"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("FILE2.txt"));
            byte[] buf = new byte[1024];
            int count;
            while ((count = bis.read(buf)) != -1) {
                bos.write(buf, 0, count);
                System.out.print(new String(buf, 0, count));
            }
            bos.flush();
            bis.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
