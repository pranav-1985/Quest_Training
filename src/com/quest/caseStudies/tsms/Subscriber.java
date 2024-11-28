package com.quest.caseStudies.tsms;

import java.util.ArrayList;

public class Subscriber {

    private int SubscriberId;
    private String name;
    private String phoneNumber;
    private String plan;
    private double balance;
    private ArrayList<CallHistory> callRecords;

    public Subscriber(int SubscriberId, String name, String phoneNumber, String plan, double balance) {
        setSubscriberId(SubscriberId);
        setName(name);
        setPhoneNumber(phoneNumber);
        setPlan(plan);
        setBalance(balance);
        this.callRecords = new ArrayList<>();

    }

    public int getSubscriberId() {
        return SubscriberId;
    }

    public void setSubscriberId(int SubscriberId) {
        if (SubscriberId <= 0) {
            throw new IllegalArgumentException("Subscriber ID must be a positive number.");
        }
        this.SubscriberId = SubscriberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number must not be empty.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        if (plan == null || !(plan.equalsIgnoreCase("Prepaid") || plan.equalsIgnoreCase("Postpaid"))) {
            throw new IllegalArgumentException("Plan must be either 'Prepaid' or 'Postpaid'.");
        }
        this.plan = plan;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    public ArrayList<CallHistory> getCallRecords() {
        return new ArrayList<>(callRecords);
    }

    public void setCallRecords(ArrayList<CallHistory> callRecords) {
        if (callRecords == null) {
            throw new IllegalArgumentException("Call records list cannot be null.");
        }
        this.callRecords = new ArrayList<>(callRecords); // Store a copy for encapsulation
    }

    public void addCallRecordDetails(CallHistory callRecord) {
        if (callRecord == null) {
            throw new IllegalArgumentException("Call record cannot be null.");
        }
        this.callRecords.add(callRecord);
    }

    @Override
    public String toString() {
        return String.format(
                "Subscriber [Id: %d, Name: %s, Phone Number: %s, Plan: %s, Balance: %.2f, Call Records Count: %d]",
                SubscriberId, name, phoneNumber, plan, balance, callRecords.size()
        );
    }
}