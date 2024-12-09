package com.quest.threads;

import java.io.FileInputStream;

public class FileProcessor implements Runnable{

    String FileName;

    public FileProcessor(String FileName){
        this.FileName=FileName;
    }

    public String getFileName() {
        return this.FileName;
    }

    @Override
    public void run() {
        try(FileInputStream fis = new FileInputStream(getFileName())){
            int count;
            System.out.println("Filename: "+getFileName());
            while ((count = fis.read()) != -1) {
                System.out.print((char) count);
            }
            System.out.println("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}