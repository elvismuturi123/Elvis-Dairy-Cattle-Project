package com.example.dairyproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CattleAnalysis extends Fragment {
    BarChart cattleBarChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList<BarEntry> cattleBarEntry;
    String[] cattleCategories;
    int bullCount,cowsCount,hieferCount,weanersCount,calvesCount,steersCount;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_cattle_analysis, container, false);
        cattleBarChart=view.findViewById(R.id.cattleBarChart);
        cattleBarEntry=new ArrayList<>();

        setBarChart();
        return view;
    }

    private void setBarChart() {
        DatabaseReference mRef= FirebaseDatabase.getInstance().getReference("cattle_details");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}