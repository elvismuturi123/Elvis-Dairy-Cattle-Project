package com.example.dairyproject;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.dairyproject.DashboardActivity;
import com.example.dairyproject.EventsActivity;
import com.example.dairyproject.NotificationsActivity;
import com.example.dairyproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Cattle_Control extends AppCompatActivity {

    CardView myEventsCardView;
    CardView myViewCardView;
    CardView myLearnCardView;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cattle_control);

        myEventsCardView = findViewById(R.id.events_card_id);
        myViewCardView = findViewById(R.id.view_card_id);
        myLearnCardView = findViewById(R.id.learn_card_id);
        myEventsCardView.setOnClickListener(v -> Toolbox.navigateTo(Cattle_Control.this, AddEvents.class));
        myViewCardView.setOnClickListener(v -> Toolbox.navigateTo(Cattle_Control.this, ViewEventsActivity.class));

    }
}

//    private void openActivity(Class<?> activityClass) {
//        startActivity(new Intent(this, activityClass));
//    }

    // Override onOptionsItemSelected to handle options menu item clicks



