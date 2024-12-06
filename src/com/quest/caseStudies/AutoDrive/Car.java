package com.quest.caseStudies.AutoDrive;

import java.time.LocalDate;

public class Car extends Vehicle {

    private int seatingCapacity;

    public Car(String vehicleId, String brand, String model, double price, LocalDate manufactureDate, int seatingCapacity) {
        super(vehicleId, brand, model, price, manufactureDate);
        setSeatingCapacity(seatingCapacity);
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        if (seatingCapacity <= 0) {
            throw new IllegalArgumentException("Seating capacity must be greater than 0.");
        }
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return "Car{vehicle=%s, seatingCapacity=%d}"
                .formatted(super.toString(), seatingCapacity);
    }
}
