package com.quest.caseStudies.BMWServiceM;

import java.util.HashSet;
import java.util.Set;

public class ServiceCenter <T extends Vehicle>{
    private Set<T> servicedVehicles;

    public ServiceCenter(){
        this.servicedVehicles=new HashSet<>();
    }

    public Set<T> getAllServicedVehicles() {
        return this.servicedVehicles;
    }

    public void addServicedVehicle(T vehicle){
        if(vehicle==null){
            throw new IllegalArgumentException("Vehicle is empty");
        }
        servicedVehicles.add(vehicle);
    }

}
