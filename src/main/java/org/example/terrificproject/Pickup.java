package org.example.terrificproject;

import java.time.LocalDate;
import java.util.ArrayList;


public class Pickup extends Vehicle {
    private double loadCapacity;

    public Pickup(String year, String make, String model, String color, String powertrain, ArrayList<LocalDate> rentalDates, String image, double loadCapacity, int pricePerDay, String vin, String mileage) {
        super(year, make, model, color, "Pickup", powertrain, rentalDates, image, pricePerDay, vin, mileage);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

}
