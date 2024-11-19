package com.quest.oops.bankmanagement;

import java.util.Scanner;

public class Withdraw extends Transaction {

    @Override
    public void processTransaction(BankAccount[] accounts, int accountCount, int accountNumber) {

        int accountIndex = findAccountIndex(accounts, accountCount, accountNumber);

        if (accountIndex != -1) {

            BankAccount account = accounts[accountIndex];

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Withdrawal Amount: ");
            double withdrawAmount = sc.nextDouble();

            String accountType = account.getAccountType();

            if ("Savings".equals(accountType)) {
                if (account.getBalance() - withdrawAmount >= SavingsAccount.MIN_BALANCE) {
                    account.setBalance(account.getBalance() - withdrawAmount);
                    System.out.println("Withdrawn: $" + withdrawAmount);
                    System.out.println("New Balance: $" + account.getBalance());
                } else {
                    System.out.println("Withdrawal failed: Insufficient funds or below minimum balance.");
                }

            } else if ("Current".equals(accountType)) {

                if (account.getBalance() - withdrawAmount >= CurrentAccount.OVERDRAFT_LIMIT) {
                    account.setBalance(account.getBalance() - withdrawAmount);
                    System.out.println("Withdrawn: $" + withdrawAmount);
                    System.out.println("New Balance: $" + account.getBalance() + "limit: " + CurrentAccount.OVERDRAFT_LIMIT);
                } else {
                    System.out.println("Withdrawal failed: Insufficient funds or below minimum balance.");
                }

            } else {
                System.out.println("Unknown account type.");
            }

        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void transactionCompleted() {
        System.out.println("Withdrawal transaction completed.");
        super.transactionCompleted();
    }

    // Helper method to find account index by account number
    private int findAccountIndex(BankAccount[] accounts, int accountCount, int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accountNumber == accounts[i].getAccountNumber()) {
                return i;
            }
        }
        return -1;
    }
}
