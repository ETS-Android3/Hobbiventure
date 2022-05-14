package com.example.bottomnavigation.ui.search;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.databinding.FragmentSearchBinding;

import java.util.ArrayList;

public class SearchFragment extends Fragment /*implements View.OnClickListener*/ {

    private FragmentSearchBinding binding;
    private CategoryViewModel categoryViewModel;
    private CategoryFragment categoryFragment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SearchViewModel searchViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final ImageButton imageButton1 = binding.category1;
        final ImageButton imageButton2 = binding.category2;
        final ImageButton imageButton3 = binding.category3;
        final ImageButton imageButton4 = binding.category4;
        final TextView outdoor = binding.textSearchOutdoor;
        final TextView indoor = binding.textSearchIndoor;
        final TextView events = binding.textSearchEvents;
        searchViewModel.getTextOutdoor().observe(getViewLifecycleOwner(), outdoor::setText);
        searchViewModel.getTextIndoor().observe(getViewLifecycleOwner(), indoor::setText);
        searchViewModel.getTextEvents().observe(getViewLifecycleOwner(), events::setText);

        final FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        imageButton1.setOnClickListener(view -> {
            fr.replace(R.id.nav_host_fragment_activity_main,new CategoryFragment());
            fr.commit();
        });
        /*imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);*/
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
  /* @Override
    public void onClick(final View view) {
switch (view.getId()){
    case R.id.category1:
    fr.replace(R.id.nav_host_fragment_activity_main, new CategoryFragment());
    fr.commit();
    break;
   /* case R.id.category2:
        break;
    case R.id.category3:
        break;
    case R.id.category4:
        break;
}
    }*/
}