package com.example.bottomnavigation.ui.survey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder>{



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.category_lists, parent, false);
        return new ViewHolder(view);
        }

    private ArrayList<Place> places;

    ResultAdapter(ArrayList<Place> places) {
        this.places = places;
    }

public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name.setText(places.get(position).getName());
        }

@Override
public int getItemCount() {
        return places.size();
        }



class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView name;

    ViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_name);
         }

}
}

