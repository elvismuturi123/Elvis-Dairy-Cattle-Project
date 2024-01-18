package com.example.dairyproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MilkingTimeReport extends Fragment {
    PieChart milkPiechart;

    ArrayList<PieEntry> ictEntry;

    DatabaseReference mRef;
    List<Integer> eveningProductionList,morningProductionList,afternoonProductionList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_milking_time_report, container, false);
        milkPiechart=view.findViewById(R.id.milkingTimeChart);
        ictEntry=new ArrayList<PieEntry>();
        eveningProductionList=new ArrayList<Integer>();
        morningProductionList=new ArrayList<Integer>();
        afternoonProductionList=new ArrayList<Integer>();
        mRef= FirebaseDatabase.getInstance().getReference("Milk_Details");

        fetchMilkProduction();
        computeTotals(morningProductionList,afternoonProductionList,eveningProductionList);
        return view;
    }

    public void computeTotals(List<Integer> morningProductionList, List<Integer> afternoonProductionList, List<Integer> eveningProductionList) {
//        System.out.println(morningProductionList.get(0));
        int morningTotal=0;

        for(int n=0;n<morningProductionList.size();n++){
            morningTotal+=morningProductionList.get(n);
        }
        System.out.printf("The sum for the morning is %d",morningTotal);
    }

    public void fetchMilkProduction() {
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Milk milkDetail=dataSnapshot.getValue(Milk.class);
                    int eveningProduction= Integer.parseInt(milkDetail.getEvening_Total());
                    int morningProduction= Integer.parseInt(milkDetail.getMorning_Total());
                    int afternoonProduction= Integer.parseInt(milkDetail.getAfternoon_Total());

                    morningProductionList.add(morningProduction);
                    eveningProductionList.add(eveningProduction);
                    afternoonProductionList.add(afternoonProduction);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Database Error",error.getMessage());
            }
        });
    }
}