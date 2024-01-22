package com.example.dairyproject;

public class Milk {
    String cattleIdentifier;
    String milkDay_id;
    String milking_Date;
    double morning_Total;
    double afternoon_Total;
    double evening_Total;
    double milk_Total;
    String milk_Notes;

    public Milk() {
    }
    public Milk(String cattleIdentifier, String milkDay_id, String milking_Date, double morning_Total,
                double afternoon_Total, double evening_Total, double milk_Total, String milk_Notes) {
        this.cattleIdentifier = cattleIdentifier;
        this.milkDay_id = milkDay_id;
        this.milking_Date = milking_Date;
        this.morning_Total = morning_Total;
        this.afternoon_Total = afternoon_Total;
        this.evening_Total = evening_Total;
        this.milk_Total = milk_Total;
        this.milk_Notes = milk_Notes;
    }


    public String getCattleIdentifier() {
        return cattleIdentifier;
    }

    public void setCattleIdentifier(String cattleIdentifier) {
        this.cattleIdentifier = cattleIdentifier;
    }

    public String getMilkDay_id() {
        return milkDay_id;
    }

    public void setMilkDay_id(String milkDay_id) {
        this.milkDay_id = milkDay_id;
    }

    public String getMilking_Date() {
        return milking_Date;
    }

    public void setMilking_Date(String milking_Date) {
        this.milking_Date = milking_Date;
    }

    public double getMorning_Total() {
        return morning_Total;
    }

    public void setMorning_Total(double morning_Total) {
        this.morning_Total = morning_Total;
    }

    public double getAfternoon_Total() {
        return afternoon_Total;
    }

    public void setAfternoon_Total(double afternoon_Total) {
        this.afternoon_Total = afternoon_Total;
    }

    public double getEvening_Total() {
        return evening_Total;
    }

    public void setEvening_Total(double evening_Total) {
        this.evening_Total = evening_Total;
    }

    public double getMilk_Total() {
        return milk_Total;
    }

    public void setMilk_Total(double milk_Total) {
        this.milk_Total = milk_Total;
    }

    public String getMilk_Notes() {
        return milk_Notes;
    }

    public void setMilk_Notes(String milk_Notes) {
        this.milk_Notes = milk_Notes;
    }
}
