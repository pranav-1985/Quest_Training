package com.quest.caseStudies.BMWServiceM;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleOperations vehicleOperations = new VehicleOperations();
        ServiceBookingOperations<Customer, ServiceBooking> serviceBookingOperations = new ServiceBookingOperations<>();
        ServiceCenter<Vehicle> vehicleServiceCenter = new ServiceCenter<>();


        boolean running = true;

        while (running) {
            try{
                System.out.println("""
                    \n===== BMW Service Management =====
                    1. Manage Vehicles
                    2. Manage Customers & Service Bookings
                    3. Generate Service Report
                    4. View Service Report
                    5. Serialize Booking Data
                    6. Deserialize Booking Data
                    7. Exit
                    Enter your choice:""");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:

                        System.out.println("""
                            \n===== Vehicle Management =====
                            1. Add a Vehicle
                            2. Filter Vehicles
                            3. Display All Vehicles
                            4. Group Vehicles by Type
                            5. Add Vehicle to Serviced List
                            6. Display All Serviced Vehicles
                            7. Custom Print Vehicle Details
                            8. Print a Random Vehicle for Testing
                            9. Calculate Resale Value
                            10. Find Oldest Vehicle
                            11. Go Back
                            Enter your choice:""");
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
                        System.out.println("""
                            \n===== Customer & Service Booking Management =====
                            1. Add Service Booking
                            2. View Service Bookings for Customer
                            3. Display All Service Bookings
                            4. Find if Vehicle Service is in a Week
                            5. Print Invoice
                            6. Produce a Random Booking Case
                            7. Go Back
                            Enter your choice:""");
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
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}
