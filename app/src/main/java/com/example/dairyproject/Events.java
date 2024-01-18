package com.example.dairyproject;

public class Events {
    String event_id;
    String event_Date;
    String event_Type;
    String Symptoms;
    String Diagnosis;
    String Technician;
    String event_Notes;

    public Events() {
    }

    public Events(String eventId, String evDate, String evType) {
    }
    public Events(String event_id, String event_Date, String event_Type, String symptoms, String diagnosis, String technician, String event_Notes) {
        this.event_id = event_id;
        this.event_Date = event_Date;
        this.event_Type = event_Type;
        Symptoms = symptoms;
        Diagnosis = diagnosis;
        Technician = technician;
        this.event_Notes = event_Notes;
    }

    public String getEvent_id() {
        return event_id;
    }

    public String getEvent_Date() {
        return event_Date;
    }

    public String getEvent_Type() {
        return event_Type;
    }

    public String getSymptoms() {
        return Symptoms;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public String getTechnician() {
        return Technician;
    }

    public String getEvent_Notes() {
        return event_Notes;
    }
}
