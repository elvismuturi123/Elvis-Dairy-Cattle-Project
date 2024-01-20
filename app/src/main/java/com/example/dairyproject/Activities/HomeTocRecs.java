package com.example.dairyproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.dairyproject.R;

public class HomeTocRecs extends AppCompatActivity {

    Button exploreDC;
// Explore to display cattle details
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_toc_recs);

        exploreDC = findViewById(R.id.navHomeTocRec_button);

        exploreDC.setOnClickListener(v -> Toolbox.navigateTo(HomeTocRecs.this, Display_cattle.class));


    }
}