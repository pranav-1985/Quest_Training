package com.quest.caseStudies.tsms;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TelecomSystem tsmsManager = new TelecomSystem();
        String filename = "subscribers_data.ser";

        tsmsManager.loadDataFromFile(filename);

        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option:" +
                    "\n1. Add Subscriber" +
                    "\n2. Add Call History" +
                    "\n3. Get Subscriber" +
                    "\n4. Get Call History" +
                    "\n5. Get All Subscribers" +
                    "\n6. Generate Postpaid Bill" +
                    "\n7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter SubscriberID");
                        int subscriberID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the name of the subscriber");
                        String name = scanner.nextLine();
                        System.out.println("Enter the phone number");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Enter the plan");
                        String plan = scanner.nextLine();
                        System.out.println("enter the balance");
                        double balance = scanner.nextInt();
                        Subscriber subscriber = new Subscriber(subscriberID, name, phoneNumber, plan, balance);
                        tsmsManager.addSubscriber(subscriber);
                    } catch (IllegalArgumentException | InputMismatchException e) {
                        System.out.println("invalid input try again");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Enter SubscriberID");
                        int subscriberID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("enter the Type of call");
                        String type = scanner.nextLine();
                        System.out.println("Enter the Duration in minutes");
                        double duration = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("enter The timestamp");
                        String timestamp = scanner.nextLine();
                        CallHistory history = new CallHistory(type, duration, timestamp);

                    } catch (IllegalArgumentException | InputMismatchException e) {
                        System.out.println("invalid input try again");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Enter SubscriberID");
                        int subscriberID = scanner.nextInt();
                        scanner.nextLine();
                        tsmsManager.getSubscriber(subscriberID);
                    } catch (IllegalArgumentException | InputMismatchException e) {
                        System.out.println("invalid input try again");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Enter SubscriberID");
                        int sID = scanner.nextInt();
                        scanner.nextLine();
                        tsmsManager.getCallHistory(sID);
                    } catch (IllegalArgumentException | InputMismatchException e) {
                        System.out.println("invalid input try again");
                    }
                    break;
                case 5:
                    System.out.println("Current Subscribers");
                    tsmsManager.getAllSubscribers();
                    break;
                case 6:
                    System.out.println("Generated Bill fo all Postpaid Users");
                    tsmsManager.generatePostpaidBill();
                    break;
                case 7:
                    tsmsManager.saveDataToFile(filename);
                    System.out.println("Data saved. Exiting the program...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
        scanner.close();
    }
}

