package com.quest.oops.bankmanagement;

import java.util.Scanner;

public class AccountManagement {

    public static BankAccount[] accounts = new BankAccount[10];
    public static int accountCount = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Bank Management System");
        System.out.println("Select option\n" +
                "1)Create Account\n" +
                "2)Deposit Cash\n" +
                "3)Withdraw Cash\n" +
                "4) View Account Details\n" +
                "5)exit\n");
        int option = sc.nextInt();
        boolean manage = true;
        while (manage) {
            switch (option) {
                case 1:
                    createAccount(sc);
                    System.out.println("Account Created");
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    int depositAccountNumber = sc.nextInt();
                    Transaction deposit = new Deposit();
                    deposit.processTransaction(accounts, accountCount, depositAccountNumber);
                    deposit.transactionCompleted();
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    int withdrawAccountNumber = sc.nextInt();
                    Transaction withdraw = new Withdraw();
                    withdraw.processTransaction(accounts, accountCount, withdrawAccountNumber);
                    withdraw.transactionCompleted();
                    break;
                case 4:
                    viewAccountDetails(sc);
                    break;
                case 5:
                    manage = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }


    public static void createAccount(Scanner sc) {
        System.out.println("enter the type of account needed 1) Savings Account 2) Current Account");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("enter the name of account Holder");
                String sName = sc.next();
                System.out.println("enter the desired account number");
                int sNumber = sc.nextInt();
                System.out.println("Savings account must have atleast 1000 minimum balance ");
                System.out.println("enter the amount to deposit");
                double sAmount = sc.nextDouble();
                boolean sValidAmount = false;
                while (!sValidAmount) {
                    if (sAmount < 1000) {
                        System.out.println("enter a valid amount to deposit, cant be less than 1000");
                        sAmount = sc.nextDouble();
                    } else {
                        sValidAmount = true;
                    }
                }
                SavingsAccount savingsAccount = new SavingsAccount(sName, sNumber, sAmount);
                accounts[accountCount] = savingsAccount;
                accountCount++;
            case 2:
                System.out.println("enter the name of account Holder");
                System.out.println("enter the name of account Holder");
                String cName = sc.next();
                System.out.println("enter the desired account number");
                int cNumber = sc.nextInt();
                System.out.println("Savings account must have atleast 1000 minimum balance ");
                System.out.println("enter the amount to deposit");
                double cAmount = sc.nextDouble();
                boolean cValidAmount = false;
                while (!cValidAmount) {
                    if (cAmount < 0) {
                        System.out.println("enter a valid amount to deposit, cant be less than 0");
                        cAmount = sc.nextDouble();
                    } else {
                        cValidAmount = true;
                    }
                }
                CurrentAccount currentAccount = new CurrentAccount(cName, cNumber, cAmount);
                accounts[accountCount] = currentAccount;
                accountCount++;

        }
    }

    public static void viewAccountDetails(Scanner sc) {
        System.out.println("Enter account number to view details:");
        int accountNumber = sc.nextInt();
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                accounts[i].displayAccountDetails();
            } else {
                System.out.println("Invalid account number");
            }
        }
    }
}
