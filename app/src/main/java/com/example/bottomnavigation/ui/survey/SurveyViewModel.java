package com.example.bottomnavigation.ui.survey;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bottomnavigation.R;

public class SurveyViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SurveyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Hit a question button to begin the survey");


    }

    public LiveData<String> getText() {
        return mText;
    }
}