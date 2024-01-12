package com.example.dairyproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dairyproject.Cows;

import java.util.List;

public class CattleAdapter extends RecyclerView.Adapter<CattleAdapter.CattleViewHolder> {

    private List<Cows> cattleList;

    // Constructor to receive the list of cattle
    public CattleAdapter(List<Cows> cattleList) {
        this.cattleList = cattleList;
    }

    @NonNull
    @Override
    public CattleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item in the RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cattle_item_layout, parent, false); // Replace with your item layout
        return new CattleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CattleViewHolder holder, int position) {
        // Get the cow object at the current position
        Cows cow = cattleList.get(position);

        // Bind data to the views in the ViewHolder
        holder.cattleNameTextView.setText(cow.getCattle_Name()); // Update with relevant fields
        // Set other fields like breed, weight, etc.
    }

    @Override
    public int getItemCount() {
        // Return the total number of items in the list
        return cattleList.size();
    }

    // ViewHolder class to hold the views for each item
    public class CattleViewHolder extends RecyclerView.ViewHolder {

        TextView cattleNameTextView; // Add other views as needed

        public CattleViewHolder(@NonNull View itemView) {
            super(itemView);

            // Find the views in the item layout
            cattleNameTextView = itemView.findViewById(R.id.cname); // Update with IDs from your layout
            // Find other views
        }
    }
}
