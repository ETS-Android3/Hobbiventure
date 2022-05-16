package com.example.bottomnavigation.ui.survey;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.databinding.FragmentSurveyBinding;

public class SurveyFragment extends Fragment {

    private FragmentSurveyBinding binding;

    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SurveyViewModel surveyViewModel = new ViewModelProvider(this).get(SurveyViewModel.class);
        binding = FragmentSurveyBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        final TextView textView = binding.textSurvey;
        final CheckBox checkbox1 = binding.checkBox;
        final CheckBox checkbox2 = binding.checkBox2;
        final CheckBox checkbox3 = binding.checkBox3;
        final Button button1 = binding.confirmButton;
        final Button button2 = binding.confirmButton2;
        final Button button3 = binding.confirmButton3;
        final Button button4 = binding.confirmButton4;
        final Button button5 = binding.SaveButton;

        button1.setOnClickListener(view -> {
            String result = "Selected checkbox";
            checkbox1.setChecked(false);
            checkbox2.setChecked(false);
            checkbox3.setChecked(false);
            textView.setText("Do you prefer to practise activities outside?");
        });

        button2.setOnClickListener(view -> {
            checkbox1.setChecked(false);
            checkbox2.setChecked(false);
            checkbox3.setChecked(false);
            textView.setText("Do you prefer to run or walk?");
        });

        button3.setOnClickListener(view -> {
            checkbox1.setChecked(false);
            checkbox2.setChecked(false);
            checkbox3.setChecked(false);
            textView.setText("Do you often create something artistic?");
        });

        button4.setOnClickListener(view -> {
            checkbox1.setChecked(false);
            checkbox2.setChecked(false);
            checkbox3.setChecked(false);
            textView.setText("Do you expect to practice an activity for 5+ hours a week?");
        });
        button5.setOnClickListener(view -> {
            String result = "Selected answer";
            if(checkbox1.isChecked()){
                result += "\nYes";
            }
            if(checkbox2.isChecked()){
                result += "\nNotSure";
            }
            if(checkbox3.isChecked()){
                result += "\nNo";
            }
            Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();

        });

        surveyViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onCheckboxClicked (View view) {
        boolean checked = ((CheckBox) view).isChecked();
        String str = "";
        switch(view.getId()) {
            case R.id.checkBox:
                str = checked?"Yes Selected":"Yes Deselected";
                break;
            case R.id.checkBox2:h:
                str = checked?"Not sure Selected":"No sure Deselected";
                break;
            case R.id.checkBox3:
                str = checked?" No Selected":"NO Deselected";
                break;
        }
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();

    }
}
