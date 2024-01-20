package com.example.dairyproject.Adapters;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dairyproject.JavaClasses.Milk;
import com.example.dairyproject.R;
import com.example.dairyproject.PopulateActivity.View_all_milk_details;

import java.util.ArrayList;

public class MilkAdapter extends RecyclerView.Adapter<MilkAdapter.MyViewHolder> {

    Context context;
    ArrayList <Milk> retrievedMilkArraylist;
    public MilkAdapter(Context context, ArrayList retrievedMilkArraylist) {
        this.context = context;
        this.retrievedMilkArraylist = retrievedMilkArraylist;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_display_item_milk, parent, false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Milk milk =retrievedMilkArraylist.get(position);
        holder.milkDate.setText(milk.getMilking_Date());
        holder.milkMorningTotal.setText(milk.getMorning_Total());
        holder.milkAllTotal.setText(milk.getMilk_Total());
        String milkgDayId = milk.getMilkDay_id();

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, View_all_milk_details.class);
            intent.putExtra("milkDay_ID", milkgDayId);
            context.startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return retrievedMilkArraylist == null ? 0 : retrievedMilkArraylist.size();
    }
    public  static  class  MyViewHolder extends RecyclerView.ViewHolder{

        TextView milkDate,milkMorningTotal,milkAllTotal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            milkDate =itemView.findViewById(R.id.disp_milkingDate);
            milkMorningTotal =itemView.findViewById(R.id.disp_morningTotal);
            milkAllTotal =itemView.findViewById(R.id.disp_milkTotal);
        }
    }
}
