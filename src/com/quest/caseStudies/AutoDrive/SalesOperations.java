package com.quest.caseStudies.AutoDrive;

import java.util.Map;
import java.util.Set;

public interface SalesOperations {
    void addCustomer(Customer customer);

    Customer findCustomer(String customerId);

    void deleteCustomer(String customerId);


    boolean addPurchasedVehicle(Customer customer, Vehicle vehicle);

    void SerializeCustomerData(Map<Customer, Set<Vehicle>> customerData, String filename);

    Map<Customer, Set<Vehicle>> DeserializeCustomerData(String filename);

    void sortVehicleByDESCPrice();

    void printPurchaseTime();
}
