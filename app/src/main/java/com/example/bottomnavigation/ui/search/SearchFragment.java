package com.example.bottomnavigation.ui.search;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavigation.databinding.FragmentSearchBinding;
import com.example.bottomnavigation.ui.home.MapsFragment;
import com.example.bottomnavigation.ui.profile.SettingsFragment;


public class SearchFragment extends Fragment /*implements View.OnClickListener*/ {

    private FragmentSearchBinding binding;
    private CategoryViewModel mCategoryViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SearchViewModel searchViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        final ImageButton imageButton1 = binding.udendoerssport;
        final ImageButton imageButton2 = binding.vildmark;
        final ImageButton imageButton3 = binding.indendoerssport;
        final ImageButton imageButton4 = binding.hjemkundskab;
        final ImageButton top10 = binding.event1;
        final TextView outdoor = binding.textSearchOutdoor;
        final TextView indoor = binding.textSearchIndoor;
        final TextView events = binding.textSearchEvents;
        searchViewModel.getTextOutdoor().observe(getViewLifecycleOwner(), outdoor::setText);
        searchViewModel.getTextIndoor().observe(getViewLifecycleOwner(), indoor::setText);
        searchViewModel.getTextEvents().observe(getViewLifecycleOwner(), events::setText);

        final FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        top10.setOnClickListener(view -> {
            fr.replace(R.id.nav_host_fragment_activity_main,new MapsFragment());
            fr.commit();});
        imageButton1.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(getActivity(), CategoryActivityUdendoers.class);
            getActivity().startActivity(intent);
        });
        imageButton2.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(getActivity(), CategoryActivityVildmark.class);
            getActivity().startActivity(intent);
        });
        imageButton3.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(getActivity(), CategoryActivityIndendoers.class);
            getActivity().startActivity(intent);
        });
        imageButton4.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(getActivity(), CategoryActivityHjemkundsskab.class);
            getActivity().startActivity(intent);
        });

        /*
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