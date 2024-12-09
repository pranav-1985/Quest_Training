package com.quest.threads;


public class ThreadJoinSleepExample {

    public static void main(String[] args) {
        // Create three threads
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();

        try {
            thread1.start();
            thread1.join();

            thread2.start();
            thread2.join();

            thread3.start();
            thread3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("Hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("World");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

