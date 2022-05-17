package com.example.bottomnavigation.ui.search;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PlaceAdaptor mAdapter;
    private CategoryViewModel mCategoryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        mRecyclerView = findViewById(R.id.rv);
        mCategoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        mCategoryViewModel.initVM();
        mCategoryViewModel.initUS();
        mCategoryViewModel.initIS();
        mCategoryViewModel.initHK();

        mCategoryViewModel.getPlaces().observe(this, new Observer<List<Place>>() {
            @Override
            public void onChanged(@Nullable List<Place> places) {
                mAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();

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