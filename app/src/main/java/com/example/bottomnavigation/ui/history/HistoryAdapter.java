package com.example.bottomnavigation.ui.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import java.util.ArrayList;
import java.util.Random;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.history_list, parent, false);
        return new ViewHolder(view);
    }
    private ArrayList<History> histories;

    HistoryAdapter(ArrayList<History> histories) {
        this.histories = histories;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(histories.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView name;

    ViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.history_name);
    }}
}

