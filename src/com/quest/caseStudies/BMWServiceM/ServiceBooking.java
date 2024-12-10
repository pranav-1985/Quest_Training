package com.quest.caseStudies.BMWServiceM;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ServiceBooking implements Serializable,Cloneable {

    private String bookingId;
    private Customer customer;
    private LocalDateTime serviceDate;
    private String serviceType;
    private double cost;

    public ServiceBooking(String bookingId, Customer customer, LocalDateTime serviceDate, String serviceType, double cost) {
        setBookingId(bookingId);
        setCustomer(customer);
        setServiceDate(serviceDate);
        setServiceType(serviceType);
        setCost(cost);
    }


    public String getBookingId() {
        return this.bookingId;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public LocalDateTime getServiceDate() {
        return this.serviceDate;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public double getCost() {
        return this.cost;
    }


    public void setBookingId(String bookingId) {
        if (bookingId == null) {
            throw new IllegalArgumentException("Booking ID cannot be empty or null.");
        }
        this.bookingId = bookingId;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        this.customer = customer;
    }

    public void setServiceDate(LocalDateTime serviceDate) {
        if (serviceDate == null) {
            throw new IllegalArgumentException("Service date cannot be null.");
        }
        this.serviceDate = serviceDate;
    }

    public void setServiceType(String serviceType) {
        if (serviceType == null) {
            throw new IllegalArgumentException("Service type cannot be empty or null.");
        }
        this.serviceType = serviceType;
    }

    public void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative.");
        }
        this.cost = cost;
    }


    @Override
    public String toString() {
        return String.format("Booking ID: %s\nCustomer: %s\nService Date: %s\nService Type: %s\nTotalCost: %.2f",
                this.bookingId, this.customer.getName(), this.serviceDate.toString(), this.serviceType, this.cost);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ServiceBooking cloned = (ServiceBooking) super.clone();
        cloned.customer = this.customer;
        return cloned;
    }
}

