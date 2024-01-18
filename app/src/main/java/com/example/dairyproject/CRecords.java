package com.example.dairyproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;

import java.util.ArrayList;
import java.util.Calendar;


public class CRecords extends AppCompatActivity {

    TextView textView;
   // EditText cowBirthDate;
    DatePickerDialog.OnDateSetListener listener;
    EditText cowName;
    EditText tagNumber;
    EditText breed;
    EditText Weight;
    EditText dateOfBirth;
    EditText short_notes;
    Button Save_data;
    String cowID = " " ;
    DatabaseReference cattleDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crecords);


        //cowBirthDate = findViewById(R.id.birth_date);

        cowName = findViewById(R.id.cname);
        tagNumber = findViewById(R.id.ctagnumber);
        breed = findViewById(R.id.breed_id);
        Weight = findViewById(R.id.cWeight);
        dateOfBirth = findViewById(R.id.birth_date);
        short_notes = findViewById(R.id.notes_id);
        Save_data = findViewById(R.id.save_button);
        //ListView listView2 = findViewById(R.id.listview1);

        cattleDbRef = FirebaseDatabase.getInstance().getReference("cattle_details");

        Save_data.setOnClickListener(v -> {

            DatabaseReference new_cow_record = cattleDbRef.push();
            String autoGeneratedId = new_cow_record.getKey();

            cowID =autoGeneratedId;
            String cattle_Name = cowName.getText().toString();
            String tagNo = tagNumber.getText().toString();
            String cow_Breed = breed.getText().toString();
            String cattle_Weight = Weight.getText().toString();
            String DateOfBirth = dateOfBirth.getText().toString();
            String SNotes = short_notes.getText().toString();


            Cows new_cow = new Cows (cowID,cattle_Name, tagNo, cow_Breed, cattle_Weight, DateOfBirth, SNotes);
            new_cow_record.setValue(new_cow, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {

                    if(error != null){
                        Toolbox.showToast(getApplicationContext(),error.getMessage());
                    }else {
                        // data was saved
                        Toolbox.showToast(CRecords.this,"Data saved successfully");
                        Toolbox.navigateTo(getApplicationContext(), Display_cattle.class);
                    }
                }
            });
        });
        tagNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        Weight.setInputType(InputType.TYPE_CLASS_NUMBER);

//------------------Date Picker----------------------

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        //----------TextView on_Click----------
        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              DatePickerDialog datePickerDialog = new DatePickerDialog(CRecords.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, (DatePickerDialog.OnDateSetListener) listener,year,month,day);
              datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
              datePickerDialog.show();
            }
        });
        listener = new DatePickerDialog.OnDateSetListener(){
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                dateOfBirth.setText(date);
            }
        };
}









}