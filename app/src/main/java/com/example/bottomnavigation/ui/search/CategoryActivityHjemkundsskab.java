package com.example.bottomnavigation.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.ui.survey.ResultFragment;

import java.util.List;

public class CategoryActivityHjemkundsskab extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PlaceAdaptor mAdapter;
    private CategoryViewModel mCategoryViewModel;
    ImageButton goBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mRecyclerView = findViewById(R.id.rv);
        goBack = findViewById(R.id.back);
        mCategoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        mCategoryViewModel.initHK();

        mCategoryViewModel.getPlaces().observe(this, places -> mAdapter.notifyDataSetChanged());
        initRecyclerView();

        goBack.setOnClickListener(view -> {
            startActivity(new Intent(this, SearchFragment.class));
            finish();
        });
    }

    private void initRecyclerView() {
        mAdapter = new PlaceAdaptor(this, mCategoryViewModel.getPlaces().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //virker ikke
    }
}