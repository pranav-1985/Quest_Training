package com.quest.caseStudies.AutoDrive;

import java.time.LocalDate;

public class Bike extends Vehicle {

    private int engineCapacity;

    public Bike(String vehicleId, String brand, String model, double price, LocalDate manufactureDate, int engineCapacity) {
        super(vehicleId, brand, model, price, manufactureDate);
        setEngineCapacity(engineCapacity);
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        if (engineCapacity <= 0) {
            throw new IllegalArgumentException("Engine capacity must be greater than 0.");
        }
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "Bike{vehicle=%s, engineCapacity=%d}"
                .formatted(super.toString(), engineCapacity);
    }
}
