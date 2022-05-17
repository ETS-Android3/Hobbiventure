package com.example.bottomnavigation.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HistoryViewModel historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);

        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RecyclerView recyclerView = binding.historyActivities;
        final FragmentTransaction fr = getParentFragmentManager().beginTransaction();

        ArrayList<History> histories = new ArrayList<>();
        histories.add(new History("Last Checked activity: Asa Fodboldklub -Fodbold"));

        historyAdapter = new HistoryAdapter(histories);
        recyclerView.setAdapter(historyAdapter);
        recyclerView.hasFixedSize();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        final FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        fr.detach(HistoryFragment.this);
        fr.commit();
        binding = null;
    }
}