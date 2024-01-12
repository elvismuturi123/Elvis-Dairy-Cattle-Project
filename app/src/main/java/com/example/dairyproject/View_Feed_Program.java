package com.example.dairyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class View_Feed_Program extends AppCompatActivity {
 


    Button LogOutA;
    Button AddA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feed_program);
        
      LogOutA = findViewById(R.id.LogoutA);
      AddA = findViewById(R.id.Add_1);


        }


    }
