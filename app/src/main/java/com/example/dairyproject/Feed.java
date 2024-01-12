package com.example.dairyproject;

public class Feed {
    String MilkProduced;
    String CattleNumber;
    String FeedingDtae;
    String FeedTpe;
    String Components;
    String ProgramNotes;

    public Feed(String milkProduced, String cattleNumber, String feedingDtae, String feedTpe, String components, String programNotes) {
        MilkProduced = milkProduced;
        CattleNumber = cattleNumber;
        FeedingDtae = feedingDtae;
        FeedTpe = feedTpe;
        Components = components;
        ProgramNotes = programNotes;
    }

    public String getMilkProduced() {
        return MilkProduced;
    }

    public String getCattleNumber() {
        return CattleNumber;
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

    public String getProgramNotes() {
        return ProgramNotes;
    }
}
