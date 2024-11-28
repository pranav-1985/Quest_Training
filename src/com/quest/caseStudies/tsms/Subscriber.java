package com.quest.caseStudies.tsms;

import java.io.Serializable;
import java.util.ArrayList;

public class Subscriber implements Serializable {

    private int subscriberId;
    private String name;
    private String phoneNumber;
    private String plan;
    private double balance;
    private ArrayList<CallHistory> callRecords;

    public Subscriber(int subscriberId, String name, String phoneNumber, String plan, double balance) {
        setSubscriberId(subscriberId);
        setName(name);
        setPhoneNumber(phoneNumber);
        setPlan(plan);
        setBalance(balance);
        this.callRecords = new ArrayList<>();

    }

    public int getSubscriberId() {
        return this.subscriberId;
    }

    public void setSubscriberId(int SubscriberId) {
        if (SubscriberId <= 0) {
            throw new IllegalArgumentException("Subscriber ID must be a positive number.");
        }
        this.subscriberId = SubscriberId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number must not be empty.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPlan() {
        return this.plan;
    }

    public void setPlan(String plan) {
        if (plan == null || !(plan.equalsIgnoreCase("Prepaid") || plan.equalsIgnoreCase("Postpaid"))) {
            throw new IllegalArgumentException("Plan must be either 'Prepaid' or 'Postpaid'.");
        }
        this.plan = plan;
    }

    public double getBalance() {
        return this.balance;
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
        this.callRecords = new ArrayList<>(callRecords);
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
                subscriberId, name, phoneNumber, plan, balance, callRecords.size()
        );
    }
}
