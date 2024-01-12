package com.example.dairyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;

public class WelcomeFprogram extends AppCompatActivity {


    Button navToFprogram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_fprogram);

        navToFprogram = findViewById(R.id.welFeed_button);

        navToFprogram.setOnClickListener(v -> Toolbox.navigateTo(WelcomeFprogram.this, AddFeedingProgram.class));




    }
}