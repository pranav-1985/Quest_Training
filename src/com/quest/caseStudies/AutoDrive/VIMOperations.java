package com.quest.caseStudies.AutoDrive;

import java.util.List;

public interface VIMOperations {
    void addVehicle(Vehicle vehicle);

    void removeVehicle(Vehicle vehicle);

    Vehicle findVehicle(String vehicleId);

    List<Vehicle> findByBrand(String brand);
}
