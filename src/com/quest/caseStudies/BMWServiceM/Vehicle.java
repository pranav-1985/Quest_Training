package com.quest.caseStudies.BMWServiceM;

public class Vehicle {
    private String vin;
    private String brand;
    private String model;
    private int year;
    private double mileage;
    private String ownerName;
    private double price;

    public Vehicle(String vin,String brand, String model, int year, double mileage, String ownerName,double price){
            setVin(vin);
            setBrand(brand);
            setModel(model);
            setYear(year);
            setMileage(mileage);
            setOwnerName(ownerName);
            setPrice(price);

    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if(price<=0){
            throw new IllegalArgumentException("price cant be zero");
        }
        this.price=price;
    }

    public String getVin() {
        return this.vin;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public double getMileage() {
        return this.mileage;
    }

    public int getYear() {
        return this.year;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setVin(String vin) {
        if(vin==null){
            throw new IllegalArgumentException("Vin cannot be empty");
        }
        this.vin=vin;
    }

    public void setBrand(String brand) {
        if(brand==null){
            throw new IllegalArgumentException("brand cannot be empty");
        }
        this.brand = brand;
    }

    public void setModel(String model) {
        if(model==null){
            throw new IllegalArgumentException("model cannot be empty");
        }
    }
    public void setMileage(double mileage) {
        if (mileage < 0) {
            throw new IllegalArgumentException("Mileage cannot be negative");
        }
        this.mileage = mileage;
    }

    public void setYear(int year) {
        if (year < 1900 | year>2025) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.year = year;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null) {
            throw new IllegalArgumentException("Owner name cannot be empty");
        }
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return String.format("Vehicle Info:\nVin: %s\nBrand: %s\nModel: %s\nYear: %d\nMileage: %.2f km\nOwner: %s",
                vin, brand, model, year, mileage, ownerName);
    }

}
