package com.quest.oops.casestudy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of cities: ");
        int numOfCity = sc.nextInt();
        CityCollection cityCollection = new CityCollection(numOfCity);// Create a CityCollection object

        // Menu
        int choice;
        do {
            System.out.println("\n--- Weather Report Menu ---\n" +
                    "1. Add City\n" +
                    "2. Display Single City\n" +
                    "3. Display all cities\n" +
                    "4. Update City Details\n" +
                    "5. Generate Report\n" +
                    "6. Exit\n" +
                    "\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Add City
                    sc.nextLine();  // Consume newline
                    System.out.print("Enter city name: ");
                    String cityName = sc.nextLine();
                    System.out.print("Enter temperature: ");
                    double temp = sc.nextDouble();
                    System.out.print("Enter humidity: ");
                    int humidity = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    System.out.print("Enter weather condition: ");
                    String weatherCondition = sc.nextLine();

                    cityCollection.addCity(cityName, temp, humidity, weatherCondition);
                    break;

                case 2: // Display Single City
                    sc.nextLine();  // Consume newline
                    System.out.print("Enter city name: ");
                    String searchCityName = sc.nextLine();
                    cityCollection.displaySingleCity(searchCityName);
                    break;

                case 3:// Display All Cities
                    System.out.println("\n--- Displaying All Cities ---");
                    cityCollection.displayAllCities();
                    break;

                case 4: // Update City Details
                    sc.nextLine();  // Consume newline
                    System.out.print("Enter city name to update: ");
                    String updateCityName = sc.nextLine();
                    cityCollection.updateCityDetails(updateCityName);
                    break;

                case 5: // Generate Report
                    System.out.println("\n--- Generating Report ---");
                    // Calling all the methods related to the report generation

                    cityCollection.hightempLowtemp();//low temp high temp city

                    System.out.print("\nEnter the humidity threshold to check city: ");
                    int humidityThreshold = sc.nextInt();
                    cityCollection.humidtyMorethan(humidityThreshold);
                    sc.nextLine();  // Consume newline

                    System.out.print("\nEnter the weather condition to group cities: ");
                    String weatherConditionGroup = sc.nextLine();
                    cityCollection.groupCityOnCondition(weatherConditionGroup);
                    cityCollection.calculateAvgTemperature();

                    System.out.print("\nEnter the temperature threshold for heatwave warning: ");
                    double tempThreshold = sc.nextDouble();
                    cityCollection.tempWarning(tempThreshold);

                    System.out.print("\nEnter the humidity threshold for low humidity warning: ");
                    int humidityWarningThreshold = sc.nextInt();
                    cityCollection.humidityDrop(humidityWarningThreshold);

                    break;

                case 6: // Exit
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);  // Continue until user chooses to exit
    }
}

