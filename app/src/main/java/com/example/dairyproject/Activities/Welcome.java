package com.example.dairyproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dairyproject.R;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button login = findViewById(R.id.btn_goToLogin);
        Button register = findViewById(R.id.btn_goToRegister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toolbox.navigateTo(Welcome.this, Login.class);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toolbox.navigateTo(Welcome.this, Register.class);
            }
        });
    }
}