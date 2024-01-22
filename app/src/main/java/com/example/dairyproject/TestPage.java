package com.example.dairyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dairyproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TestPage extends AppCompatActivity {

    FloatingActionButton addNotebtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_page);


        addNotebtn = findViewById(R.id.add_testbtn);



    }
}