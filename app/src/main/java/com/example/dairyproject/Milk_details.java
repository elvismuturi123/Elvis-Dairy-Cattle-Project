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

public class Milk_details extends AppCompatActivity {

    DatePickerDialog.OnDateSetListener listener;
    TextView textView;

    EditText milking_cDate;
    EditText morning_cTotal;
    EditText afternoon_cTotal;
    EditText evening_cTotal;
    EditText total_cMilk;
    EditText milk_cNotes;
    Button save_Records;


DatabaseReference milkDbRef;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_details);

    milking_cDate = findViewById(R.id.milking_date);
    morning_cTotal = findViewById(R.id.morning_total);
    afternoon_cTotal = findViewById(R.id.afternoon_total);
    evening_cTotal = findViewById(R.id.evening_total);
    total_cMilk = findViewById(R.id.milk_total);
    milk_cNotes = findViewById(R.id.Milk_notes_id);
    save_Records = findViewById(R.id.save_mButton);


    milkDbRef = FirebaseDatabase.getInstance().getReference().child("Milk_Details");

    save_Records.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            insertMilkRecords();
        }
        private void insertMilkRecords(){

           String milking_Date = milking_cDate.getText().toString();
           String morning_Total = morning_cTotal.getText().toString();
           String afternoon_Total = afternoon_cTotal.getText().toString();
           String evening_Total = evening_cTotal.getText().toString();
           String milk_Total = total_cMilk.getText().toString();
           String milk_Notes = milk_cNotes.getText().toString();





           Milk milk = new Milk(milking_Date, morning_Total, afternoon_Total, evening_Total, milk_Total,milk_Notes);
           milkDbRef.push().setValue(milk);

            Toast.makeText(Milk_details.this, "Milk records updated successfully!!", Toast.LENGTH_SHORT).show();
            Toolbox.navigateTo(Milk_details.this, Display_milk.class);

        }

    });



// Date picker dialog -------
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);




        // Make the keyboard input numbers
        morning_cTotal.setInputType(InputType.TYPE_CLASS_NUMBER);
        afternoon_cTotal.setInputType(InputType.TYPE_CLASS_NUMBER);
        evening_cTotal.setInputType(InputType.TYPE_CLASS_NUMBER);
        total_cMilk.setInputType(InputType.TYPE_CLASS_NUMBER);





        milking_cDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Milk_details.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, (DatePickerDialog.OnDateSetListener) listener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                datePickerDialog.show();

            }

        });
        listener = new DatePickerDialog.OnDateSetListener(){
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                milking_cDate.setText(date);
            }
        };







    }
}