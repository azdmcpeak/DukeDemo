package com.example.dukedemo;

public class Vehicle1{

    private String Year;
    private String Make;
    private String Model;
    private String Color;
    private String Mileage;
    private String Vin;


    public Vehicle1(){
    }

    public Vehicle1(String year, String make, String model, String color, String mileage, String vin){
        this.Year = year;
        this.Make = make;
        this.Model = model;
        this.Color = color;
        this.Mileage = mileage;
        this.Vin = vin;

    }

    public void setYear(String year) {
        Year = year;
    }

    public String getYear() {
        return Year;
    }


    public void setMake(String make) {
        Make = make;
    }

    public String getMake() {
        return Make;
    }


    public void setModel(String model) {
        Model = model;
    }

    public String getModel() {
        return Model;
    }


    public void setColor(String color) {
        Color = color;
    }

    public String getColor() {
        return Color;
    }


    public void setMileage(String milage) {
        Mileage = milage;
    }

    public String getMileage() {
        return Mileage;
    }


    public void setVin(String vin) {
        Vin = vin;
    }


    public String getVin() {
        return Vin;
    }

    public String toString(){
        return "Year: " + this.Year + "\n" + "Make: " + this.Make + "\n" + "Model: " + this.Model + "\n" + "Color: " + this.Color + "\n" + "Mileage: " + this.Mileage + "\n" + "Vin: " + this.Vin;
    }
}
