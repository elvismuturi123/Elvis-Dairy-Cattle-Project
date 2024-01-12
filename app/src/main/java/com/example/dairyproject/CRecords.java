package com.example.dairyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;


public class CRecords extends AppCompatActivity {

    TextView textView;
    EditText editText;
    DatePickerDialog.OnDateSetListener listener;

    EditText cowName;
    EditText tagNumber;
    EditText breed;
    EditText Weight;
    EditText dateOfBirth;
    EditText short_notes;
    Button Save_data;




    DatabaseReference cattleDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crecords);


        editText = findViewById(R.id.birth_date);
        cowName = findViewById(R.id.cname);
        tagNumber = findViewById(R.id.ctagnumber);
        breed = findViewById(R.id.breed_id);
        Weight = findViewById(R.id.cWeight);
        dateOfBirth = findViewById(R.id.birth_date);
        short_notes = findViewById(R.id.notes_id);
        Save_data = findViewById(R.id.save_button);


        cattleDbRef = FirebaseDatabase.getInstance().getReference().child("Cattle_Details");

        Save_data.setOnClickListener(new View.OnClickListener() {



            public void onClick(View view) {insertCattleData();}


            private void insertCattleData(){
                String cattle_Name = cowName.getText().toString();
                String tagNo = tagNumber.getText().toString();
                String cow_Breed = breed.getText().toString();
                String cattle_Weight = Weight.getText().toString();
                String DateOfBirth = dateOfBirth.getText().toString();
                String SNotes = short_notes.getText().toString();


                    Cows cows = new Cows (cattle_Name, tagNo, cow_Breed, cattle_Weight, DateOfBirth, SNotes);

                cattleDbRef.push().setValue(cows);


                Toast.makeText(CRecords.this, "Data Inserted successfully", Toast.LENGTH_SHORT).show();
                Toolbox.navigateTo(CRecords.this, Display_cattle.class);


            }

        });


        tagNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        Weight.setInputType(InputType.TYPE_CLASS_NUMBER);







        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        //----------TextView on_Click----------

        editText.setOnClickListener(new View.OnClickListener() {
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
                editText.setText(date);
            }
        };






        //--------------Insert cattle data ----------------
}



}