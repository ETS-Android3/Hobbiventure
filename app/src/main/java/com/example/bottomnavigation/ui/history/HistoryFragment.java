package com.example.bottomnavigation.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.databinding.FragmentHistoryBinding;


import java.util.ArrayList;

public class HistoryFragment extends Fragment {


    private FragmentHistoryBinding binding;
    HistoryAdapter historyAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HistoryViewModel historyViewModel =
                new ViewModelProvider(this).get(HistoryViewModel.class);

        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RecyclerView recyclerView = binding.HistoryRec;

        recyclerView.hasFixedSize();

        ArrayList<History> histories = new ArrayList<>();
        histories.add(new History("Last performed survey: 4.05 PM 5/17/2022"));
        histories.add(new History(""));
        histories.add(new History(""));

        histories.add(new History("Contact Charlie - for customer support - TEL: 88899224"));


        historyAdapter = new HistoryAdapter(histories);
        recyclerView.setAdapter(historyAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}