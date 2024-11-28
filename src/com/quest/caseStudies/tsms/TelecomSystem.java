package com.quest.caseStudies.tsms;

import java.io.*;
import java.util.ArrayList;

public class TelecomSystem implements ManageTSMS, Serializable {

    private ArrayList<Subscriber> subscribers;

    public TelecomSystem() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if (subscriber != null) {
            if (!subscribers.contains(subscriber)) {
                subscribers.add(subscriber);
                System.out.println("added subscriber");
            } else {
                System.out.println("subscriber already exists");
            }
        } else {
            throw new NullPointerException("Subscriber is null");
        }

    }

    @Override
    public void addCallRecord(int subscriberId, CallHistory callRecord) {
        if (callRecord == null) {
            throw new IllegalArgumentException("Call history cannot be null");
        }
        if (subscriberId <= 0) {
            throw new IllegalArgumentException("Invalid subscriber ID");
        }
        Subscriber subscriber = findSubscriber(subscriberId);
        if (subscriber != null) {
            subscriber.addCallRecordDetails(callRecord);
            System.out.println("Call record added");
        } else {
            System.out.println("Subscriber with ID " + subscriberId + " not found.");
        }

    }

    @Override
    public void getSubscriber(int subscriberId) {
        if (subscriberId <= 0) {
            throw new IllegalArgumentException("Invalid subscriber ID");
        }
        Subscriber subscriber = findSubscriber(subscriberId);
        if (subscriber != null) {
            System.out.println(subscriber);
        } else {
            System.out.println("Subscriber with ID " + subscriberId + " not found.");
        }

    }

    @Override
    public void getCallHistory(int subscriberId) {
        Subscriber subscriber = findSubscriber(subscriberId);
        if (subscriber != null) {
            if (subscriber.getCallRecords().isEmpty()) {
                System.out.println("No call history available");
            } else {
                System.out.println("Call history for subscriber with ID " + subscriberId + ":");
                for (CallHistory callRecord : subscriber.getCallRecords()) {
                    System.out.println(callRecord);
                }
            }
        } else {
            System.out.println("Subscriber not found.");
        }
    }

    @Override
    public void getAllSubscribers() {
        if (subscribers.isEmpty()) {
            System.out.println("No subscribers available.");
        } else {
            System.out.println("All Subscribers:");
            for (Subscriber subscriber : subscribers) {
                System.out.println(subscriber);
            }
        }
    }

    @Override
    public void generatePostpaidBill() {

        boolean foundPostpaidSubscriber = false;

        for (Subscriber subscriber : subscribers) {

            if ("Postpaid".equalsIgnoreCase(subscriber.getPlan())) {
                foundPostpaidSubscriber = true;
                double totalBill = 0;

                for (CallHistory callRecord : subscriber.getCallRecords()) {
                    // Get the call type from CallHistory and use the getRate() method
                    CallType callType = callRecord.getTypeOfCall();
                    double rate = callType.getRate();

                    totalBill = totalBill + (rate * callRecord.getDuration());
                }

                System.out.printf("Bill for subscriber %s (ID: %d): %.2f\n",
                        subscriber.getName(), subscriber.getSubscriberId(), totalBill);
            }
        }

        if (!foundPostpaidSubscriber) {
            System.out.println("No postpaid subscribers found.");
        }
    }

    @Override
    public void saveDataToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(subscribers); // Write the subscribers list to the file
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    @Override
    public void loadDataFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            subscribers = (ArrayList<Subscriber>) ois.readObject(); // Read the subscribers list from the file
            System.out.println("Data loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }

    //helper method
    public Subscriber findSubscriber(int subscriberId) {
        for (Subscriber s : subscribers) {
            if (s.getSubscriberId() == subscriberId) {
                return s;
            }
        }
        return null;
    }
}
