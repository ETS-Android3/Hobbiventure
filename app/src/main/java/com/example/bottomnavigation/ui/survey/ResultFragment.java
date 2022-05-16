package com.example.bottomnavigation.ui.survey;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.databinding.FragmentResultBinding;

import java.util.ArrayList;


public class ResultFragment extends Fragment {

    private FragmentResultBinding binding;
    ResultAdapter resultAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ResultViewModel resultViewModel = new ViewModelProvider(this).get(ResultViewModel.class);

        binding = FragmentResultBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button button = binding.returnBtn;
        final RecyclerView recyclerView = binding.rvActivities;

        final FragmentTransaction fr = getParentFragmentManager().beginTransaction();

        button.setOnClickListener(view -> {
            fr.replace(R.id.nav_host_fragment_activity_main, new SurveyFragment());
            fr.commit();
        });

        ArrayList<Place> udendoersSportList = new ArrayList<>();
        udendoersSportList.add(new com.example.bottomnavigation.ui.survey.Place("Asa Fodboldklub - Fodbold"));
        udendoersSportList.add(new com.example.bottomnavigation.ui.survey.Place("Aarhus 1900 - Atletik"));
        udendoersSportList.add(new com.example.bottomnavigation.ui.survey.Place("True Skov - Løb"));
        udendoersSportList.add(new com.example.bottomnavigation.ui.survey.Place("Marselisborgskovene - Cykel"));
        udendoersSportList.add(new com.example.bottomnavigation.ui.survey.Place("Vestereng - Discgolf"));
        udendoersSportList.add(new com.example.bottomnavigation.ui.survey.Place("Aarhus Ø - Surf"));
        udendoersSportList.add(new com.example.bottomnavigation.ui.survey.Place("Aarhus Watersports Complex - Watersports"));



        resultAdapter = new ResultAdapter(udendoersSportList);
        recyclerView.setAdapter(resultAdapter);
        recyclerView.hasFixedSize();

        return root;


    }
}
