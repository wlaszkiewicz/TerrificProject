package org.example.terrificproject;

import java.time.LocalDate;
import java.util.ArrayList;

public class Vehicle {
    public String year;
    public String make;
    public String model;
    public String color;
    public String type; // Car, Motorcycle, Pickup, Camper
    public String powertrain; // Internal Combustion Engine (ICE), Hybrid, Battery Electric Vehicle (BEV)
    public ArrayList<LocalDate> rentalDates;

    public String imagePath;

    public int pricePerDay;

    public String vin;

    public String mileage;

    public Vehicle(String year, String make, String model, String color, String type, String powertrain, ArrayList<LocalDate> rentalDates, String imagePath, int pricePerDay, String vin, String mileage) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.type = type;
        this.powertrain = powertrain;
        this.rentalDates = rentalDates;
        this.imagePath = imagePath;
        this.pricePerDay = pricePerDay;
        this.vin = vin;
        this.mileage = mileage;
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

    public ArrayList<LocalDate> getRentalDates() {
        return rentalDates;
    }

    public void setRentalDates(ArrayList<LocalDate> rentalDates) {
        this.rentalDates = rentalDates;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public void setYear(String year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPowertrain(String powertrain) {
        this.powertrain = powertrain;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model + " " + color + " " + type + " " + powertrain;

    }
}
