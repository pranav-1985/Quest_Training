package com.quest.caseStudies.BMWServiceM;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleOperations vehicleOperations = new VehicleOperations();
        ServiceBookingOperations<Customer, ServiceBooking> serviceBookingOperations = new ServiceBookingOperations<>();
        ServiceCenter<Vehicle> vehicleServiceCenter = new ServiceCenter<>();


        boolean running = true;

        while (running) {
            System.out.println("\n===== BMW Service Management =====");
            System.out.println("1. Manage Vehicles");
            System.out.println("2. Manage Customers & Service Bookings");
            System.out.println("3. Generate Service Report");
            System.out.println("4. View Service Report");
            System.out.println("5. Serialize Booking Data");
            System.out.println("6. Deserialize Booking Data");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    System.out.println("\n===== Vehicle Management =====");
                    System.out.println("1. Add a Vehicle");
                    System.out.println("2. Filter Vehicles");
                    System.out.println("3. Display All Vehicles");
                    System.out.println("4. Group Vehicles by Type");
                    System.out.println("5. Add Vehicle to Serviced List");
                    System.out.println("6. Display All Serviced Vehicles");
                    System.out.println("7. custom print vehicle details");
                    System.out.println("8. print a random vehicle for testing");
                    System.out.println("9. calculate resale value ");
                    System.out.println("10.find oldest vehicle");
                    System.out.println("11. Go back");
                    System.out.print("Enter your choice: ");
                    int vehicleChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline

                    switch (vehicleChoice) {
                        case 1:

                            System.out.print("Enter VIN: ");
                            String vin = scanner.nextLine();
                            System.out.print("Enter Brand: ");
                            String brand = scanner.nextLine();
                            System.out.print("Enter Model: ");
                            String model = scanner.nextLine();
                            System.out.print("Enter Year: ");
                            int year = scanner.nextInt();
                            System.out.print("Enter Mileage: ");
                            double mileage = scanner.nextDouble();
                            scanner.nextLine();  // Consume the newline
                            System.out.print("Enter Owner Name: ");
                            String ownerName = scanner.nextLine();
                            System.out.print("Enter Price: ");
                            double price = scanner.nextDouble();

                            System.out.println("1. Electric Vehicle");
                            System.out.println("2. Combustion Engine Vehicle");
                            System.out.print("Choose Vehicle Type: ");
                            int vehicleType = scanner.nextInt();

                            if (vehicleType == 1) {
                                System.out.print("Enter Battery Capacity (kWh): ");
                                double batteryCapacity = scanner.nextDouble();
                                System.out.print("Enter Range Per Charge (km): ");
                                double rangePerCharge = scanner.nextDouble();

                                ElectricVehicle electricVehicle = new ElectricVehicle(vin, brand, model, year, mileage, ownerName, price, batteryCapacity, rangePerCharge);
                                vehicleOperations.getAllVehicles().add(electricVehicle);
                            } else if (vehicleType == 2) {
                                System.out.print("Enter Fuel Type: ");
                                String fuelType = scanner.next();
                                System.out.print("Enter Engine Capacity (L): ");
                                double engineCapacity = scanner.nextDouble();

                                CombustionEngineVehicle combustionEngineVehicle = new CombustionEngineVehicle(vin, brand, model, year, mileage, ownerName, price, fuelType, engineCapacity);
                                vehicleOperations.getAllVehicles().add(combustionEngineVehicle);
                            } else {
                                System.out.println("Invalid choice.");
                            }
                            break;

                        case 2:
                            List<Vehicle> filteredVehicles=vehicleOperations.filterVehicles();
                            System.out.println("Filtered Vehicles:");
                            filteredVehicles.forEach(vehicle -> System.out.println(vehicle.getVin() + " - " + vehicle.getMileage() + " km"));
                            break;

                        case 3:
                            System.out.println("\nAll Vehicles: ");
                            vehicleOperations.getAllVehicles().forEach(vehicle -> System.out.println(vehicle.getVin() + " - " + vehicle.getMileage() + " km"));
                            break;

                        case 4:
                            vehicleOperations.groupVehiclesByType();
                            break;

                        case 5://add vehicle to serviced list
                            System.out.print("Choose Vehicle, VehicleVIN : ");
                            String vehicleAddChoice = scanner.nextLine();
                            Vehicle x=vehicleOperations.findVehicle(vehicleAddChoice);
                            if (x!=null){
                                vehicleServiceCenter.addServicedVehicle(x);
                            }else{
                                System.out.println("vehicle with VIN not found");
                            }

                        case 6:
                            System.out.println("Serviced Vehicles:");
                            vehicleServiceCenter.getAllServicedVehicles().forEach(vehicle -> System.out.println(vehicle.getVin() + " - " + vehicle.getMileage() + " km"));
                            break;
                        case 7:
                            System.out.println("enter the vin for custom print");
                            String customVin=scanner.nextLine();
                            Vehicle customV=vehicleOperations.findVehicle(customVin);
                            vehicleOperations.customPrint.accept(customV);
                            break;
                        case 8:
                            System.out.println("Random vehicle");
                            System.out.println(vehicleOperations.randomVehicleSupplier.get().toString());
                            break;
                        case 9:
                            System.out.println("enter the vin for resale value");
                            String resaleVin=scanner.nextLine();
                            Vehicle resaleV=vehicleOperations.findVehicle(resaleVin);
                            double resaleValue=vehicleOperations.calculateResaleValue.apply(resaleV);
                            System.out.println("Resale value: "+resaleValue);
                            break;
                        case 10:
                            System.out.println("enter the vin for oldest value");
                            String oldVin=scanner.nextLine();
                            Vehicle oldV=vehicleOperations.findVehicle(oldVin);
                            System.out.println(vehicleOperations.findOldestVehicle().toString());
                            break;
                        case 11:
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;

                case 2:
                    // Customer and Service Booking Management
                    System.out.println("\n===== Customer & Service Booking Management =====");
                    System.out.println("1. Add Service Booking");
                    System.out.println("2. View Service Bookings for Customer");
                    System.out.println("3. Display All Service Bookings");
                    System.out.println("4. find if vehicle service is in a week");
                    System.out.println("5. print invoice");
                    System.out.println("6. produce a random booking case");
                    System.out.println("7. go back");
                    System.out.print("Enter your choice: ");
                    int serviceChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline

                    switch (serviceChoice) {
                        case 1:
                            // Add a new service booking
                            System.out.print("Enter Customer ID: ");
                            String customerId = scanner.nextLine();
                            System.out.print("Enter Customer Name: ");
                            String customerName = scanner.nextLine();
                            System.out.print("Enter Customer Email: ");
                            String customerEmail = scanner.nextLine();
                            System.out.print("Enter Vehicle VIN: ");
                            String vehicleVin = scanner.nextLine();

                            Vehicle vehicle = vehicleOperations.getAllVehicles().stream()
                                    .filter(v -> v.getVin().equals(vehicleVin))
                                    .findFirst()
                                    .orElse(null);

                            if (vehicle != null) {
                                Customer customer = new Customer(customerId, customerName, customerEmail, vehicle);
                                System.out.print("Enter Service Booking ID: ");
                                String bookingId = scanner.nextLine();
                                System.out.print("Enter Service Type: ");
                                String serviceType = scanner.nextLine();
                                System.out.print("Enter Cost: ");
                                double cost = scanner.nextDouble();
                                ServiceBooking serviceBooking = new ServiceBooking(bookingId, customer, LocalDateTime.now(), serviceType, cost);
                                try {
                                    serviceBookingOperations.addServiceBooking(customer, serviceBooking);
                                } catch (InvalidBookingException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            } else {
                                System.out.println("Vehicle not found.");
                            }
                            break;

                        case 2:
                            // View Service Bookings for Customer
                            System.out.print("Enter Customer ID to view bookings: ");
                            String customerIdToView = scanner.nextLine();
                            Customer customerToView = serviceBookingOperations.bookings.keySet().stream()
                                    .filter(customer1 -> customer1.getCustomerId().equals(customerIdToView))
                                    .findFirst()
                                    .orElse(null);

                            if (customerToView != null) {
                                List<ServiceBooking> customerBookings = serviceBookingOperations.getServiceBookingsForCustomer(customerToView);
                                customerBookings.forEach(System.out::println);
                            } else {
                                System.out.println("Customer not found.");
                            }
                            break;

                        case 3:
                            // Display All Service Bookings
                            serviceBookingOperations.displayAllBookings();
                            break;
                        case 4:
                            //is scheduled in a week
                            System.out.println("enter booking id");
                            String bookId= scanner.nextLine();
                            ServiceBooking booking=serviceBookingOperations.findBooking(bookId);
                            if(booking!=null){
                                serviceBookingOperations.isScheduledInAWeek.test(booking);
                            }else{
                                System.out.println("booking not found");
                            }
                            break;
                        case 5:
                            System.out.println("enter the customer id to print invoice");
                            String cId= scanner.nextLine();
                            Customer customer=serviceBookingOperations.findCustomer(cId);
                            serviceBookingOperations.invoice.accept(customer);
                        case 6:
                            System.out.println("random booking data");
                            System.out.println(serviceBookingOperations.randomBooking.toString());
                            break;
                        case 7:
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;

                case 3:
                    serviceBookingOperations.CreateServiceReport();
                    break;
                case 4:
                    serviceBookingOperations.readServiceReport();
                    break;

                case 5:
                    // Serialize Booking Data
                    serviceBookingOperations.SerializeBookingData();
                    break;

                case 6:
                    // Deserialize Booking Data
                    serviceBookingOperations.DeserializeBookingData();
                    break;

                case 7:
                    // Exit the program
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        scanner.close();
    }
}
