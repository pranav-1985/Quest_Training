package com.quest.caseStudies.AutoDrive;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SalesManagement salesManagement = new SalesManagement();
        VehicleInventoryManagement vehicleInventory = new VehicleInventoryManagement();
        String filename = "customerData.ser";

//        initializeData(vehicleInventory, salesManagement);

        // Load the previously serialized data
        Map<Customer, Set<Vehicle>> customerData = salesManagement.DeserializeCustomerData(filename);
        if (customerData != null) {
            // Deserialize customer data if available
            salesManagement = new SalesManagement();
            salesManagement.getCustomersMap().putAll(customerData);
        }

        // Main menu loop
        while (true) {
            try {
                System.out.println("\n--- Main Menu ---\n" +
                        "1. Add Vehicle\n" +
                        "2. Remove Vehicle\n" +
                        "3. Find Vehicle\n" +
                        "4. Find Vehicles by Brand\n" +
                        "5. Add Customer\n" +
                        "6. Find Customer\n" +
                        "7. Delete Customer\n" +
                        "8. Purchase Vehicle\n" +
                        "9. Sort Vehicles by Price (DESC)\n" +
                        "10. Exit\n" +
                        "Enter your choice: ");


                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: // Add Vehicle
                        System.out.print("Enter vehicle ID: ");
                        String newVehicleId = scanner.nextLine();
                        System.out.print("Enter brand: ");
                        String brand = scanner.nextLine();
                        System.out.print("Enter model: ");
                        String model = scanner.nextLine();
                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter manufacture date (YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        LocalDate manufactureDate = LocalDate.parse(date);

                        Vehicle newVehicle = new Vehicle(newVehicleId, brand, model, price, manufactureDate);
                        vehicleInventory.addVehicle(newVehicle);
                        break;

                    case 2: // Remove Vehicle
                        System.out.print("Enter vehicle ID to remove: ");
                        String rVehicleId = scanner.nextLine();
                        Vehicle vehicleToRemove = vehicleInventory.findVehicle(rVehicleId);
                        if (vehicleToRemove != null) {
                            vehicleInventory.removeVehicle(vehicleToRemove);
                            System.out.println("Vehicle removed successfully.");
                        } else {
                            System.out.println("Vehicle not found.");
                        }
                        break;

                    case 3: // Find Vehicle
                        System.out.print("Enter vehicle ID to find: ");
                        String fVehicleId = scanner.nextLine();
                        Vehicle vehicle = vehicleInventory.findVehicle(fVehicleId);
                        if (vehicle != null) {
                            System.out.println(vehicle);
                        } else {
                            System.out.println("Vehicle not found.");
                        }
                        break;

                    case 4: // Find Vehicles by Brand
                        System.out.print("Enter brand to search: ");
                        String fBrand = scanner.nextLine();
                        List<Vehicle> vehiclesByBrand = vehicleInventory.findByBrand(fBrand);
                        if (vehiclesByBrand != null) {
                            System.out.println(vehiclesByBrand);
                        } else {
                            System.out.println("No vehicles found for this brand.");
                        }
                        break;

                    case 5: // Add Customer
                        System.out.print("Enter customer ID: ");
                        String cId = scanner.nextLine();
                        System.out.print("Enter customer name: ");
                        String customerName = scanner.nextLine();
                        System.out.print("Enter customer email: ");
                        String customerEmail = scanner.nextLine();
                        Customer newCustomer = new Customer(cId, customerName, customerEmail);
                        salesManagement.addCustomer(newCustomer);
                        break;

                    case 6: //find customer
                        System.out.print("Enter customer ID to find: ");
                        String customerId = scanner.nextLine();
                        Customer customer = salesManagement.findCustomer(customerId);
                        if (customer != null) {
                            System.out.println(customer);
                        } else {
                            System.out.println("Customer not found.");
                        }
                        break;

                    case 7: // Delete Customer
                        System.out.print("Enter customer ID to delete: ");
                        String dCId = scanner.nextLine();
                        salesManagement.deleteCustomer(dCId);
                        break;

                    case 8:
                        System.out.print("Enter customer ID: ");
                        String customerID = scanner.nextLine();
                        Customer nCustomer = salesManagement.findCustomer(customerID);
                        if (nCustomer == null) {
                            System.out.println("Customer not found.");
                            break;
                        }

                        System.out.print("Enter vehicle ID to purchase: ");
                        String vehicleId = scanner.nextLine();
                        Vehicle vehicleToPurchase = vehicleInventory.findVehicle(vehicleId);

                        if (vehicleToPurchase == null) {
                            throw new VehicleNotAvailableException("Vehicle not available in inventory.");
                        }

                        boolean purchased = salesManagement.addPurchasedVehicle(nCustomer, vehicleToPurchase);
                        if (purchased) {
                            vehicleInventory.removeVehicle(vehicleToPurchase);
                        }
                        break;

                    case 9: // Sort Vehicles by Price (DESC)
                        salesManagement.sortVehicleByDESCPrice();
                        break;

                    case 10: // Exit
                        // Serialize customer data back to file
                        salesManagement.SerializeCustomerData(salesManagement.getCustomersMap(), filename);
                        System.out.println("Data serialized. Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IllegalArgumentException | VehicleNotAvailableException e) {
                e.printStackTrace();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    private static void initializeData(VehicleInventoryManagement vehicleInventory, SalesManagement salesManagement) {
        DataPopulator.populateVehicleInventory(vehicleInventory);
        DataPopulator.populateCustomerData(salesManagement, vehicleInventory);

        System.out.println("Initial data loaded successfully!");
    }
}
