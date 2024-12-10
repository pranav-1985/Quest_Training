package com.quest.threads;

public class BankAccountSim {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000);


        Thread t1 = new Thread(new BankTransaction(account, "Thread-1", 100, "Deposit"));
        Thread t2 = new Thread(new BankTransaction(account, "Thread-2", 50, "Withdraw"));
        Thread t3 = new Thread(new BankTransaction(account, "Thread-3", 1200, "Withdraw"));

        try{
            t1.start();
            t1.join();
            t3.start();
            t3.join();
            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
