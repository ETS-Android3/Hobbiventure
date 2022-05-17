package com.example.bottomnavigation.ui.survey;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ResultViewModel extends ViewModel {
    private Place place;
    private final MutableLiveData<ArrayList<Place>> allPlaces;


    public ResultViewModel() {
        allPlaces = new MutableLiveData<>();
        ArrayList<Place> newList = new ArrayList<>();
        allPlaces.setValue(newList);
    }
    public MutableLiveData<ArrayList<Place>> getList(){
        return allPlaces;
    }
}
