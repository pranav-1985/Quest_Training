package com.quest.oops.bankmanagement;

import java.util.Scanner;

public class SavingsAccount extends BankAccount {
    public static final double MIN_BALANCE = 1000.00;

    public SavingsAccount(String accountHolderName, int accountNumber, double balance) {
        super(accountHolderName, accountNumber, balance, "savings");
    }

    @Override
    public void setBalance(double balance) {
        if (balance >= MIN_BALANCE) {
            boolean setBalance = false;
            while (!setBalance) {
                if (balance < 0) {
                    System.out.println("Invalid balance,try again");
                    Scanner sc = new Scanner(System.in);
                    balance = sc.nextDouble();
                } else {
                    super.setBalance(balance);
                    setBalance = true;
                }
            }
        } else {
            System.out.println("Savings account must maintain a minimum balance of $" + MIN_BALANCE);
        }
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Account Type: Savings Account");
    }
}
