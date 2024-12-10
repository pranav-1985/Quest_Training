package com.quest.caseStudies.BMWServiceM;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class VehicleOperations {

    List<Vehicle> allVehicles;

    public VehicleOperations(){
        this.allVehicles=new ArrayList<>();
    }

    public List<Vehicle> getAllVehicles() {
        return this.allVehicles;
    }

    Predicate<Vehicle> filterByMileageAndYear =
            vehicle -> vehicle.getMileage() > 50000 && vehicle.getYear() < 2015;

    public List<Vehicle> filterVehicles() {
        return allVehicles.stream()
                .filter(filterByMileageAndYear)
                .collect(Collectors.toList());
    }

    Consumer<Vehicle> customPrint=vehicle->
            System.out.printf("VIN: %s, Mileage: %.2f km%n", vehicle.getVin(), vehicle.getMileage());


    Supplier<Vehicle> randomVehicleSupplier = () -> {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return new ElectricVehicle(
                    "EV" + rand.nextInt(1000),
                    "Tesla",
                    "Model S",
                    2020,
                    rand.nextDouble() * 100000,
                    "Owner" + rand.nextInt(100),
                    rand.nextDouble() * 100000,
                    rand.nextDouble() * 100,
                    rand.nextDouble() * 500
            );
        } else {
            return new CombustionEngineVehicle(
                    "CEV" + rand.nextInt(1000),
                    "BMW",
                    "Series 3",
                    2014,
                    rand.nextDouble() * 100000,
                    "Owner" + rand.nextInt(100),
                    rand.nextDouble() * 100000,
                    "Petrol",
                    rand.nextDouble() * 6
            );
        }
    };

    Function<Vehicle, Double> calculateResaleValue = vehicle -> {
        double originalPrice = vehicle.getPrice();
        double depreciationRate = 0.15;
        int yearsUsed = 2024 - vehicle.getYear();
        return originalPrice - (depreciationRate * yearsUsed * originalPrice);
    };

    public Optional<Vehicle> findOldestVehicle() {
        return allVehicles.stream()
                .min(Comparator.comparingInt(Vehicle::getYear));
    }


    public void groupVehiclesByType() {

        int electricCount = (int) allVehicles.stream()
                .filter(vehicle -> vehicle instanceof ElectricVehicle)
                .count();


        int combustionCount = (int) allVehicles.stream()
                .filter(vehicle -> vehicle instanceof CombustionEngineVehicle)
                .count();


        System.out.println("Electric Vehicles: " + electricCount);
        System.out.println("Combustion Vehicles: " + combustionCount);
    }

    public Vehicle findVehicle(String vin){
        for(Vehicle vehicleX : getAllVehicles()){
            if(vin.equalsIgnoreCase(vehicleX.getVin())){
                return vehicleX;
            }
        }
        return null;
    }

}
