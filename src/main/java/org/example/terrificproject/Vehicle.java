package org.example.terrificproject;

import java.util.ArrayList;
import java.util.Date;

public class Vehicle {
    private String year;
    private String make;
    private String model;
    private String color;
    private String type; // Car, Motorcycle, Pickup, Camper
    private String powertrain; // Internal Combustion Engine (ICE), Hybrid, Battery Electric Vehicle (BEV)
    private ArrayList<Date> rentalDates = new ArrayList<>(); // Dates the vehicle is rented out

    public Vehicle(String year, String make, String model, String color, String type, String powertrain) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.type = type;
        this.powertrain = powertrain;
    }

    public String getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String getPowertrain() {
        return powertrain;
    }

    public ArrayList<Date> getRentalDates() {
        return rentalDates;
    }

    public void setRentalDates(ArrayList<Date> rentalDates) {
        this.rentalDates = rentalDates;
    }
}