package com.example.dairyproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.model.DatabaseId;

import java.util.Calendar;

public class AddFeedingProgram extends AppCompatActivity {


    EditText fmilkProduced;
    EditText fcattleNumber;
    EditText feedingDate;
    EditText feedType;
    EditText components;
    EditText programNotes;
    Button saveFprogram;
    String feedDayId =" ";


    DatePickerDialog.OnDateSetListener listener;

    DatabaseReference FeedingProgramDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feeding_program);

        fmilkProduced = findViewById(R.id.mproduced_id);
        fcattleNumber = findViewById(R.id.cattleNumber_id);
        feedingDate = findViewById(R.id.feed_dateid);
        feedType = findViewById(R.id.feed_typeid);
        components = findViewById(R.id.components_notesid);
        programNotes = findViewById(R.id.feed_notes_id);
        saveFprogram = findViewById(R.id.saveFProgram_Button);

        fmilkProduced.setInputType(InputType.TYPE_CLASS_NUMBER);
        fcattleNumber.setInputType(InputType.TYPE_CLASS_NUMBER);


        FeedingProgramDbRef = FirebaseDatabase.getInstance().getReference("Feeding_Program");

        saveFprogram.setOnClickListener(v -> {
            DatabaseReference new_fProgram_record = FeedingProgramDbRef.push();
            String autoGeneratedId = new_fProgram_record.getKey();

            feedDayId = autoGeneratedId;
            String MilkProduced = fmilkProduced.getText().toString();
            String CattleNumber = fcattleNumber.getText().toString();
            String FeedingDtae = feedingDate.getText().toString();
            String FeedType = feedType.getText().toString();
            String Components = components.getText().toString();
            String ProgramNotes = programNotes.getText().toString();


            Feed feed = new Feed (feedDayId, FeedingDtae,FeedType,Components, MilkProduced,CattleNumber,ProgramNotes);
//            FeedingProgramDbRef.push().setValue(feed);
//            Toast.makeText(AddFeedingProgram.this, "Data inserted succesfully", Toast.LENGTH_SHORT).show();
//            Toolbox.navigateTo(AddFeedingProgram.this, View_Feed_Program.class);

         new_fProgram_record.setValue(feed, new DatabaseReference.CompletionListener() {
             @Override
             public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {

                 if(error != null){
                     Toolbox.showToast(getApplicationContext(),error.getMessage());
                 }else {
                     // data was saved
                     Toolbox.showToast(AddFeedingProgram.this,"Data saved successfully");
                     Toolbox.navigateTo(getApplicationContext(), View_Feed_Program.class);
                 }
             }
         });

        });



















            Calendar calendar = Calendar.getInstance();
            final int year = calendar.get(Calendar.YEAR);
            final int month = calendar.get(Calendar.MONTH);
            final int day = calendar.get(Calendar.DAY_OF_MONTH);

            //----------TextView on_Click----------
            feedingDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(AddFeedingProgram.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, (DatePickerDialog.OnDateSetListener) listener, year, month, day);
                    datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                    datePickerDialog.show();
                }
            });
            listener = new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month = month + 1;
                    String date = dayOfMonth + "/" + month + "/" + year;
                    feedingDate.setText(date);
                }
            };
    }
}