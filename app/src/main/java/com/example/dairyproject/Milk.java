package com.example.dairyproject;

public class Milk {

    String milkDay_id;
    String milking_Date;
    String Morning_Total;
    String afternoon_Total;
    String evening_Total;
    String milk_Total;
    String milk_Notes;


    public Milk() {
    }

    public Milk(String milkDay_id, String milking_Date, String morning_Total, String afternoon_Total, String evening_Total, String milk_Total, String milk_Notes) {
        this.milkDay_id = milkDay_id;
        this.milking_Date = milking_Date;
        Morning_Total = morning_Total;
        this.afternoon_Total = afternoon_Total;
        this.evening_Total = evening_Total;
        this.milk_Total = milk_Total;
        this.milk_Notes = milk_Notes;
    }

    public String getMilkDay_id() {
        return milkDay_id;
    }

    public String getMilking_Date() {
        return milking_Date;
    }

    public String getMorning_Total() {
        return Morning_Total;
    }

    public String getAfternoon_Total() {
        return afternoon_Total;
    }

    public String getEvening_Total() {
        return evening_Total;
    }

    public String getMilk_Total() {
        return milk_Total;
    }

    public String getMilk_Notes() {
        return milk_Notes;
    }
}
