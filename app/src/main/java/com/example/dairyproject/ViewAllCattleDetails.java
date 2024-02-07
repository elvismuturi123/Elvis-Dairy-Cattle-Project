package com.example.dairyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ViewAllCattleDetails extends AppCompatActivity {
    ArrayList <Cows> cowsArrayList;
    RecyclerView recyclerViewAllCDetails;
    FirebaseDatabase db1 = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;
    CattleAdapter cattleAdapter;
    TextView Cow_Name;
    TextView TagNumber;
    TextView Breed;
    TextView Weight;
    TextView Birthdate;
    TextView SNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_cattle_details);
         Cow_Name = findViewById(R.id.disp_cowName);
         TagNumber = findViewById(R.id.disp_cowTagNo);
         Breed = findViewById(R.id.disp_cowBreed);
         Weight = findViewById(R.id.disp_cowWeight);
         Birthdate = findViewById(R.id.disp_cowBirthDate);
        SNotes = findViewById(R.id.disp_cowNotes);

        String cow_id = getIntent().getStringExtra("COW_ID");
        DatabaseReference docRef = FirebaseDatabase.getInstance().getReference("cattle_details").child(cow_id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    DataSnapshot snapshot = task.getResult();
                    if (snapshot.exists()) {
                        // Document exists and has data
                      //  Object documentData = snapshot.getValue();
                        // Process the retrieved data here
                        Cows retrieved_cow_data =snapshot.getValue(Cows.class);
                        Cow_Name.setText(retrieved_cow_data.getCattle_Name());
                        TagNumber.setText(retrieved_cow_data.getTagNo());
                        Breed.setText(retrieved_cow_data.getCow_Breed());
                        Weight.setText(retrieved_cow_data.getCattle_Weight());
                        Birthdate.setText(retrieved_cow_data.getDateOfBirth());
//                        SNotes.setText(retrieved_cow_data.get());
                    } else {
                        // Document does not exist
                        Log.d("TAG", "Document not found");
                    }
                } else {
                    // Handle errors
                    Log.d("TAG", "Error getting document", task.getException());
                }
            }
        });



    }
}