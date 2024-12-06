package com.quest.caseStudies.AutoDrive;


import java.io.Serializable;


public class Customer implements Serializable {
    private String customerId;
    private String name;
    private String email;


    public Customer(String customerId, String name, String email) {
        setCustomerId(customerId);
        setName(name);
        setEmail(email);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        this.email = email;
    }


    @Override
    public String toString() {
        return "Customer{customerId='%s', name='%s', email='%s'}"
                .formatted(customerId, name, email);
    }
}
