package com.quest.caseStudies.AutoDrive;

import java.time.LocalDate;

public class DataPopulator {

    public static void populateVehicleInventory(VehicleInventoryManagement vehicleInventory) {
        try {
            // Adding cars
            vehicleInventory.addVehicle(new Car("C1", "Toyota", "Camry", 24000, LocalDate.of(2019, 6, 10), 5));
            vehicleInventory.addVehicle(new Car("C2", "Honda", "Accord", 26000, LocalDate.of(2020, 8, 15), 5));
            vehicleInventory.addVehicle(new Car("C3", "Ford", "Explorer", 32000, LocalDate.of(2021, 2, 20), 7));
            vehicleInventory.addVehicle(new Car("C4", "Tesla", "Model Y", 45000, LocalDate.of(2022, 5, 5), 5));
            vehicleInventory.addVehicle(new Car("C5", "Audi", "Q5", 55000, LocalDate.of(2023, 7, 12), 5));

            // Adding bikes
            vehicleInventory.addVehicle(new Bike("B1", "Yamaha", "R15", 2000, LocalDate.of(2020, 3, 10), 150));
            vehicleInventory.addVehicle(new Bike("B2", "Kawasaki", "Ninja 300", 5500, LocalDate.of(2019, 9, 25), 300));
            vehicleInventory.addVehicle(new Bike("B3", "Royal Enfield", "Classic 350", 4500, LocalDate.of(2021, 11, 18), 350));
            vehicleInventory.addVehicle(new Bike("B4", "BMW", "G310R", 7000, LocalDate.of(2022, 4, 2), 310));
            vehicleInventory.addVehicle(new Bike("B5", "Ducati", "Scrambler", 11000, LocalDate.of(2023, 1, 5), 800));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding vehicle to inventory: " + e.getMessage());
        }
    }

    public static void populateCustomerData(SalesManagement salesManagement, VehicleInventoryManagement vehicleInventory) {
        try {
            // Adding customers
            Customer customer1 = new Customer("C1", "Alice Johnson", "alice.johnson@example.com");
            Customer customer2 = new Customer("C2", "Bob Smith", "bob.smith@example.com");
            Customer customer3 = new Customer("C3", "Charlie Brown", "charlie.brown@example.com");
            Customer customer4 = new Customer("C4", "Diana Prince", "diana.prince@example.com");
            Customer customer5 = new Customer("C5", "Ethan Hunt", "ethan.hunt@example.com");

            salesManagement.addCustomer(customer1);
            salesManagement.addCustomer(customer2);
            salesManagement.addCustomer(customer3);
            salesManagement.addCustomer(customer4);
            salesManagement.addCustomer(customer5);

            // Adding purchased vehicles to customers and removing from inventory
            salesManagement.addPurchasedVehicle(customer1, vehicleInventory.findVehicle("C1")); // Toyota Camry
            vehicleInventory.removeVehicle(vehicleInventory.findVehicle("C1"));

            salesManagement.addPurchasedVehicle(customer2, vehicleInventory.findVehicle("B1")); // Yamaha R15
            vehicleInventory.removeVehicle(vehicleInventory.findVehicle("B1"));

            salesManagement.addPurchasedVehicle(customer3, vehicleInventory.findVehicle("C2")); // Honda Accord
            vehicleInventory.removeVehicle(vehicleInventory.findVehicle("C2"));

            salesManagement.addPurchasedVehicle(customer4, vehicleInventory.findVehicle("B2")); // Kawasaki Ninja 300
            vehicleInventory.removeVehicle(vehicleInventory.findVehicle("B2"));

            salesManagement.addPurchasedVehicle(customer5, vehicleInventory.findVehicle("C3")); // Ford Explorer
            vehicleInventory.removeVehicle(vehicleInventory.findVehicle("C3"));
        } catch (IllegalArgumentException | VehicleNotAvailableException e) {
            System.out.println("Error populating customer data: " + e.getMessage());
        }
    }
}
