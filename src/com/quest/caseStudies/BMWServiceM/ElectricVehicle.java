package com.quest.caseStudies.BMWServiceM;

public class ElectricVehicle extends Vehicle{

    private double batteryCapacity;
    private double rangePerCharge;


    public ElectricVehicle(String vin, String brand, String model, int year, double mileage, String ownerName,double price,double batteryCapacity, double rangePerCharge) {
        super(vin, brand, model, year, mileage, ownerName,price);
        setBatteryCapacity(batteryCapacity);
        setRangePerCharge(rangePerCharge);
    }

    public double getBatteryCapacity() {
        return this.batteryCapacity;
    }

    public double getRangePerCharge() {
        return this.rangePerCharge;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        if(batteryCapacity<=0){
            throw new IllegalArgumentException("Battery capacity cant be 0");
        }
        this.batteryCapacity=batteryCapacity;
    }

    public void setRangePerCharge(double rangePerCharge) {
        if(rangePerCharge<=0){
            throw new IllegalArgumentException("Range per charge cant be 0");
        }
        this.rangePerCharge=rangePerCharge;
    }

    @Override
    public String toString() {
        return String.format("%s\nBattery Capacity: %.2f kWh\nRange Per Charge: %.2f km",
                super.toString(), batteryCapacity, rangePerCharge);
    }

}
