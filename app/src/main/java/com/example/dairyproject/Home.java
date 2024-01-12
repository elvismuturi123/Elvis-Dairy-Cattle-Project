package com.example.dairyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

CardView myCattleCardview = findViewById(R.id.cattle_card);
CardView myMilkCardview = findViewById(R.id.milk_card);
CardView myControlCardview = findViewById(R.id.events_card);
CardView myfProgramCardview = findViewById(R.id.fProgram_card);
 CardView myReportsCardviiew = findViewById(R.id.reports_card);
CardView myHomeCardview = findViewById(R.id.home_card);



        myCattleCardview.setOnClickListener(v -> Toolbox.navigateTo(Home.this, Display_cattle.class));
        myMilkCardview.setOnClickListener(v -> Toolbox.navigateTo(Home.this, Display_milk.class));
        myControlCardview.setOnClickListener(v -> Toolbox.navigateTo(Home.this, ControlActivity.class));
        myfProgramCardview.setOnClickListener(v -> Toolbox.navigateTo(Home.this, WelcomeFprogram.class));
        myReportsCardviiew.setOnClickListener(v -> Toolbox.navigateTo(Home.this, Home_Reports.class));

    }
}