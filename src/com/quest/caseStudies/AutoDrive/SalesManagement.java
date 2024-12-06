package com.quest.caseStudies.AutoDrive;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SalesManagement implements SalesOperations, Serializable {

    private Map<Customer, Set<Vehicle>> customersMap;

    public SalesManagement() {
        customersMap = new HashMap<Customer, Set<Vehicle>>();
    }

    @Override
    public void addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (!customersMap.containsKey(customer)) {
            Set<Vehicle> vehicles = new HashSet<Vehicle>();
            customersMap.put(customer, vehicles);
        } else {
            throw new IllegalArgumentException("Customer already exists");
        }

    }

    @Override
    public Customer findCustomer(String customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer id cannot be null");
        }
        for (Map.Entry<Customer, Set<Vehicle>> entry : customersMap.entrySet()) {
            if (entry.getKey().getCustomerId().equals(customerId)) {

                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public void deleteCustomer(String customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer id cannot be null");
        }
        Customer customer = findCustomer(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exist");
        }
        customersMap.remove(customer);
        System.out.println("Customer " + customerId + " has been deleted");

    }

    @Override
    public boolean addPurchasedVehicle(Customer customer, Vehicle vehicle) {
        if (vehicle == null | customer == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        boolean vehicleAdded = customersMap.get(customer).add(vehicle);
        if (vehicleAdded) {
            System.out.printf("Customer %s has purchased vehicle %s%n", customer.getCustomerId(), vehicle);
        } else {
            return false;

        }
        return true;
    }

    @Override
    public void SerializeCustomerData(Map<Customer, Set<Vehicle>> customerData, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(customerData);
            System.out.println("Data serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Customer, Set<Vehicle>> DeserializeCustomerData(String filename) {
        Map<Customer, Set<Vehicle>> customerData = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            customerData = (Map<Customer, Set<Vehicle>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customerData;
    }

    @Override
    public void sortVehicleByDESCPrice() {
        for (Customer customer : customersMap.keySet()) {

            List<Vehicle> sortedVehicles = customersMap.get(customer).stream()
                    .sorted((v1, v2) -> Double.compare(v2.getPrice(), v1.getPrice()))
                    .toList();

            System.out.println("Vehicles purchased by customer " + customer.getCustomerId() + " sorted by price (descending):");
            for (Vehicle vehicle : sortedVehicles) {
                System.out.println(vehicle);
            }
        }
    }


    @Override
    public void printPurchaseTime() {

    }

    public Map<Customer, Set<Vehicle>> getCustomersMap() {
        return customersMap;
    }
}
