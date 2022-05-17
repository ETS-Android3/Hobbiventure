package com.example.bottomnavigation.ui.history;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bottomnavigation.ui.survey.Place;

import java.util.ArrayList;

public class HistoryViewModel extends ViewModel {
    private History histories;
    private final MutableLiveData<ArrayList<History>> allHistories;


    public HistoryViewModel() {
        allHistories = new MutableLiveData<>();
        ArrayList<History> newList = new ArrayList<>();
        allHistories.setValue(newList);
    }

public MutableLiveData<ArrayList<History>> getList(){
            return allHistories;
    }
}
