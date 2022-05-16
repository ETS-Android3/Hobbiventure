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
import java.util.Collections;


public class ResultFragment extends Fragment {

    private FragmentResultBinding binding;
    ResultAdapter resultAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
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
        udendoersSportList.add(new Place("Asa Fodboldklub - Fodbold"));
        udendoersSportList.add(new Place("Aarhus 1900 - Atletik"));
        udendoersSportList.add(new Place("True Skov - Løb"));
        udendoersSportList.add(new Place("Marselisborgskovene - Cykel"));
        udendoersSportList.add(new Place("Vestereng - Discgolf"));
        udendoersSportList.add(new Place("Aarhus Ø - Surf"));
        udendoersSportList.add(new Place("Aarhus Watersports Complex - Watersports"));
        udendoersSportList.add(new Place("Aarhus Watersports Complex - Watersports"));

        Collections.shuffle(udendoersSportList);
        resultAdapter = new ResultAdapter(udendoersSportList);
        recyclerView.setAdapter(resultAdapter);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        final FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        fr.detach(ResultFragment.this);
        fr.commit();
        binding = null;
    }
}
