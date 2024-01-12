package com.example.dairyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ControlActivity extends AppCompatActivity {


    Button Explore;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        Explore = findViewById(R.id.explore_button);

        Explore.setOnClickListener(v -> Toolbox.navigateTo(ControlActivity.this, Cattle_Control.class));


    }
}