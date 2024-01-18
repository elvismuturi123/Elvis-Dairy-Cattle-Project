package com.example.dairyproject;

public class Feed {

    String feedDayId;
    String FeedingDtae;
    String FeedTpe;
    String Components;

    String MilkProduced;
    String CattleNumber;
    String ProgramNotes;

    public Feed() {
    }

    public Feed(String feedDayId, String feedingDtae, String feedTpe, String components, String milkProduced, String cattleNumber, String programNotes) {
        this.feedDayId = feedDayId;
        FeedingDtae = feedingDtae;
        FeedTpe = feedTpe;
        Components = components;
        MilkProduced = milkProduced;
        CattleNumber = cattleNumber;
        ProgramNotes = programNotes;
    }

    public String getFeedDayId() {
        return feedDayId;
    }

    public String getFeedingDtae() {
        return FeedingDtae;
    }

    public String getFeedTpe() {
        return FeedTpe;
    }

    public String getComponents() {
        return Components;
    }

    public String getMilkProduced() {
        return MilkProduced;
    }

    public String getCattleNumber() {
        return CattleNumber;
    }

    public String getProgramNotes() {
        return ProgramNotes;
    }
}
