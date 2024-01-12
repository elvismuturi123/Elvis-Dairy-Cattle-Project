package com.example.dairyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Display_milk extends AppCompatActivity {

    ImageButton navigate_mRecords;
    RecyclerView recyclerView;
    ImageButton menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_milk);

        recyclerView = findViewById(R.id.mRecords_RecyclerV);

         navigate_mRecords = findViewById(R.id.addmRecords);



        navigate_mRecords.setOnClickListener(v -> Toolbox.navigateTo(Display_milk.this, Milk_details.class));


    }
    void setupRecyclerView(){


    }

}