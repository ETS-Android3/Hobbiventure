package com.example.bottomnavigation.ui.survey;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavigation.databinding.FragmentSearchBinding;
import com.example.bottomnavigation.databinding.FragmentSurveyBinding;

public class SurveyFragment extends Fragment {

    private FragmentSurveyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SurveyViewModel surveyViewModel =
                new ViewModelProvider(this).get(SurveyViewModel.class);

        binding = FragmentSurveyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSurvey;
        surveyViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}