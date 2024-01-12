package com.example.dairyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Display_cattle extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton menuBtn;
    List<Cows> cattleList;
    CattleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_cattle);

        Button AddcRecords = findViewById(R.id.add_cRecords);
        recyclerView = findViewById(R.id.recycleview);
        menuBtn = findViewById(R.id.menu_btn);

        // Set up RecyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cattleList = new ArrayList<>();
        adapter = new CattleAdapter(cattleList);
        recyclerView.setAdapter(adapter);

        // Fetch data from Firebase
        DatabaseReference cattleRef = FirebaseDatabase.getInstance().getReference("Cattle_Details");
        cattleRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cattleList.clear(); // Clear existing data
                for (DataSnapshot cowSnapshot : snapshot.getChildren()) {
                    Cows cow = cowSnapshot.getValue(Cows.class);
                    cattleList.add(cow);
                }
                adapter.notifyDataSetChanged(); // Notify adapter of data change
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle errors
            }
        });

        AddcRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toolbox.navigateTo(Display_cattle.this, CRecords.class);
            }
        });
    }
}
