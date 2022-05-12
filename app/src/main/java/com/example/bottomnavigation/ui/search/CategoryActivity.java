package com.example.bottomnavigation.ui.search;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bottomnavigation.R;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView placeList;
    PlaceAdaptor placeAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_lists);

        placeList = findViewById(R.id.rv);
        placeList.hasFixedSize();
        placeList.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<PlaceFragment> places = new ArrayList<>();
        places.add(new PlaceFragment("Bulbasaur", R.drawable.outdoor_156x96px));
        places.add(new PlaceFragment("Ivysaur", R.drawable.outdoor_156x96px));
        places.add(new PlaceFragment("Venusaur", R.drawable.outdoor_156x96px));
        places.add(new PlaceFragment("Charmander", R.drawable.outdoor_156x96px));
        places.add(new PlaceFragment("Charmeleon", R.drawable.outdoor_156x96px));



        placeAdaptor = new PlaceAdaptor(places);
        placeList.setAdapter(placeAdaptor);
    }
}
