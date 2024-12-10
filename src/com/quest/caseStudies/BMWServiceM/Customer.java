package com.quest.caseStudies.BMWServiceM;

import java.io.Serializable;

public class Customer implements Serializable {

    private String customerId;
    private String name;
    private String email;
    private Vehicle vehicle;

    public Customer(String customerId, String name, String email, Vehicle vehicle) {
        setCustomerId(customerId);
        setName(name);
        setEmail(email);
        setVehicle(vehicle);
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setCustomerId(String customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID cannot be empty or null.");
        }
        this.customerId = customerId;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be empty or null.");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        this.email = email;
    }

    public void setVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        this.vehicle = vehicle;
    }


    @Override
    public String toString() {
        return String.format("Customer ID: %s\nName: %s\nEmail: %s\nVehicle: %s",
                this.customerId, this.name, this.email,  this.vehicle.getVin());
    }
}
