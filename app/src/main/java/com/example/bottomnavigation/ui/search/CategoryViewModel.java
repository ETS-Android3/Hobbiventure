package com.example.bottomnavigation.ui.search;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class CategoryViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<Place>> allPlaces;

    public CategoryViewModel() {
        allPlaces = new MutableLiveData<>();
        ArrayList<Place> newList = new ArrayList<>();
        allPlaces.setValue(newList);
    }

    public MutableLiveData<ArrayList<Place>> getList() {
        return allPlaces;
    }

}
