package com.quest.caseStudies.AutoDrive;

import java.util.ArrayList;
import java.util.List;


public class VehicleInventoryManagement implements VIMOperations {

    List<Vehicle> inventory = new ArrayList<>();

    @Override
    public void addVehicle(Vehicle vehicle) {

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle is null");
        }

        if (!inventory.contains(vehicle)) {
            inventory.add(vehicle);
        } else {
            throw new IllegalArgumentException("Vehicle already exists");
        }

    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle is null");
        }
        if (inventory.contains(vehicle)) {
            inventory.remove(vehicle);
        } else {
            throw new IllegalArgumentException("Vehicle does not exist");
        }
    }

    @Override
    public Vehicle findVehicle(String vehicleId) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        List<Vehicle> brandList = inventory.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .toList();
        if (brandList.isEmpty()) {
            return null;
        }
        return brandList;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }
}
