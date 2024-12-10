package com.quest.caseStudies.BMWServiceM;

public class CombustionEngineVehicle extends Vehicle {

    private String fuelType;
    private double engineCapacity;

    public CombustionEngineVehicle(String vin, String brand, String model, int year, double mileage, String ownerName,double price, String fuelType, double engineCapacity) {
        super(vin, brand, model, year, mileage, ownerName,price);
        setFuelType(fuelType);
        setEngineCapacity(engineCapacity);
    }

    public String getFuelType() {
        return this.fuelType;
    }

    public double getEngineCapacity() {
        return this.engineCapacity;
    }

    public void setFuelType(String fuelType) {
        if (fuelType == null) {
            throw new IllegalArgumentException("Fuel type cannot be empty");
        }
        this.fuelType = fuelType;
    }

    public void setEngineCapacity(double engineCapacity) {
        if (engineCapacity <= 0) {
            throw new IllegalArgumentException("Engine capacity must be greater than 0");
        }
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s\nFuel Type: %s\nEngine Capacity: %.2f L",
                super.toString(), fuelType, engineCapacity);
    }
}
