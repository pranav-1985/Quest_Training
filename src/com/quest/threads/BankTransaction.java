package com.quest.threads;

public class BankTransaction implements Runnable {
    private BankAccount account;
    private String threadName;
    private double amount;
    private String transactionType;

    public BankTransaction(BankAccount account, String threadName, double amount, String type) {
        this.account = account;
        this.threadName = threadName;
        this.amount = amount;
        this.transactionType=type;
    }

    @Override
    public void run() {
        if (this.transactionType.equalsIgnoreCase("Deposit")) {
            account.deposit(amount, threadName);
        } else if(this.transactionType.equalsIgnoreCase("Withdraw")) {
            account.withdraw(amount, threadName);
        }else{
            System.out.println("invalid transaction type");
        }
    }
}