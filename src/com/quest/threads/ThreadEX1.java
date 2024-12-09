package com.quest.threads;

public class ThreadEX1 {

    public static void main(String[] args) {

        for (int i = 0; i <= 10; i++) {
            ThreadA thread1 = new ThreadA(i);
            ThreadB thread2 = new ThreadB(i);

            if (i % 2 == 0) {
                thread1.start();
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                thread2.start();
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThreadA extends Thread {
        int even;

        public ThreadA(int i) {
            this.even = i;
        }

        @Override
        public void run() {
            System.out.println("thread A: " + even);
        }
    }

    public static class ThreadB extends Thread {
        int odd;

        public ThreadB(int i) {
            this.odd = i;
        }

        @Override
        public void run() {
            System.out.println("thread B: " + odd);
        }
    }
}
