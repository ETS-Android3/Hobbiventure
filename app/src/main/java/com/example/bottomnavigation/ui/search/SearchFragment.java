package com.example.bottomnavigation.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavigation.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SearchViewModel searchViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView outdoor = binding.textSearchOutdoor;
        final TextView indoor = binding.textSearchIndoor;
        final TextView events = binding.textSearchEvents;
        searchViewModel.getTextOutdoor().observe(getViewLifecycleOwner(), outdoor::setText);
        searchViewModel.getTextIndoor().observe(getViewLifecycleOwner(), indoor::setText);
        searchViewModel.getTextEvents().observe(getViewLifecycleOwner(), events::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}