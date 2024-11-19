package com.quest.oops.bankmanagement;

public class CurrentAccount extends BankAccount {

    public static final double OVERDRAFT_LIMIT = 5000;

    public CurrentAccount(String accountHolderName, int accountNumber, double balance) {
        super(accountHolderName, accountNumber, balance, "current");
    }

    @Override
    public void setBalance(double balance) {
        if (balance >= -OVERDRAFT_LIMIT) {
            super.setBalance(balance);
        } else {
            System.out.println("Balance cannot exceed overdraft limit of $" + OVERDRAFT_LIMIT);
        }
    }


    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Account Type: Current Account");
    }
}
