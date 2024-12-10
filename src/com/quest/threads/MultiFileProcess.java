package com.quest.threads;

public class MultiFileProcess{
    public static void main(String[] args) {
        try{
            FileProcessor newTask= new FileProcessor("C:/Users/ASUS/IdeaProjects/Quest_Training/src/com/quest/threads/FILE1.txt");
            Thread thread1=new Thread(newTask);
            thread1.start();

            FileProcessor newTask1= new FileProcessor("C:/Users/ASUS/IdeaProjects/Quest_Training/src/com/quest/threads/FILE2.txt");
            Thread thread2=new Thread(newTask1);
            thread2.start();

            FileProcessor newTask2= new FileProcessor("C:/Users/ASUS/IdeaProjects/Quest_Training/src/com/quest/threads/FILE3.txt");
            Thread thread3=new Thread(newTask2);
            thread3.start();

            FileProcessor newTask3= new FileProcessor("C:/Users/ASUS/IdeaProjects/Quest_Training/src/com/quest/threads/FILE4.txt");
            Thread thread4=new Thread(newTask3);
            thread4.start();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}


