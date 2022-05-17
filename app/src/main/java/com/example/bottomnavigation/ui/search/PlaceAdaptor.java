package com.example.bottomnavigation.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.bottomnavigation.ui.search.Place;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;

import java.util.ArrayList;
import java.util.List;

public class PlaceAdaptor extends RecyclerView.Adapter<PlaceAdaptor.ViewHolder> {
    private List<Place> mPlaces = new ArrayList<>();
    private Context mContext;

    public PlaceAdaptor(Context context, List<Place> places) {
        mPlaces = places;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.category_lists, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name.setText(mPlaces.get(position).getName());
        viewHolder.icon.setImageResource(mPlaces.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return mPlaces.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final ImageView icon;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            icon = itemView.findViewById(R.id.iv_icon); }

    }
}
