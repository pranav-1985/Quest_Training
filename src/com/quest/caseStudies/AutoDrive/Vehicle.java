package com.quest.caseStudies.AutoDrive;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vehicle implements Cloneable, Serializable {
    private String vehicleId;
    private String brand;
    private String model;
    private double price;
    private LocalDate manufactureDate;
    private LocalDateTime purchaseDateTime;

    public Vehicle(String vehicleId, String brand, String model, double price, LocalDate manufactureDate) {
        setVehicleId(vehicleId);
        setBrand(brand);
        setModel(model);
        setPrice(price);
        setManufactureDate(manufactureDate);
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        if (vehicleId == null || vehicleId.isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or empty.");
        }
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty.");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
        this.price = price;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        if (manufactureDate == null || manufactureDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Manufacture date cannot be null or in the future.");
        }
        this.manufactureDate = manufactureDate;
    }


    @Override
    public String toString() {
        return "Vehicle{VehicleId='%s', brand='%s', model='%s', price=%s, manufactureDate=%s}"
                .formatted(vehicleId, brand, model, price, manufactureDate);
    }

    @Override
    public Vehicle clone() {
        try {
            Vehicle clone = (Vehicle) super.clone();
            double discount = clone.getPrice() * 0.1;
            double discountedPrice = clone.getPrice() - discount;
            clone.setPrice(discountedPrice);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported.");
        }
    }
}
