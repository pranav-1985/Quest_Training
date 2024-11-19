package com.quest.oops.bankmanagement;

import java.util.Scanner;

public class Deposit extends Transaction {

    @Override
    public void processTransaction(BankAccount[] accounts, int accountCount, int accountNumber) {
        // Find the account by account number and get the index
        int accountIndex = findAccountIndex(accounts, accountCount, accountNumber);

        if (accountIndex != -1) {
            BankAccount account = accounts[accountIndex];

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Deposit Amount: ");

            double depositAmount = sc.nextDouble();
            double newBalance = account.getBalance() + depositAmount;

            account.setBalance(newBalance);

            System.out.println("Deposited: " + depositAmount);
            System.out.println("New Balance: " + account.getBalance());

        } else {
            System.out.println("Account not found!");
        }
        transactionCompleted();
    }

    @Override
    public void transactionCompleted() {
        System.out.println("Deposit completed!");
        super.transactionCompleted();
    }

    private int findAccountIndex(BankAccount[] accounts, int accountCount, int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accountNumber == accounts[i].getAccountNumber()) {
                return i;
            }
        }
        return -1;
    }
}
