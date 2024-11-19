package com.quest.oops.bankmanagement;

public abstract class Transaction {


    public abstract void processTransaction(BankAccount[] accounts, int accountCount, int accountNumber);

    public void transactionCompleted() {
        System.out.println("Transaction completed");
    }
}
