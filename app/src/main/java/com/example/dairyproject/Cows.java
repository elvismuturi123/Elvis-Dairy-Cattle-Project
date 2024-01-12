package com.example.dairyproject;

public class Cows {

    String cattle_Name;
    String tagNo;
    String cow_Breed;
    String cattle_Weight;
    String DateOfBirth;
    String SNotes;

    public Cows(String cattle_Name, String tagNo, String cow_Breed, String cattle_Weight, String dateOfBirth, String SNotes) {
        this.cattle_Name = cattle_Name;
        this.tagNo = tagNo;
        this.cow_Breed = cow_Breed;
        this.cattle_Weight = cattle_Weight;
        DateOfBirth = dateOfBirth;
        this.SNotes = SNotes;
    }

    public String getCattle_Name() {
        return cattle_Name;
    }

    public String getTagNo() {
        return tagNo;
    }

    public String getCow_Breed() {
        return cow_Breed;
    }

    public String getCattle_Weight() {
        return cattle_Weight;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public String getSNotes() {
        return SNotes;

    }



}




