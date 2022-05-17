package com.example.bottomnavigation.ui.search;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewModel extends ViewModel{
    private MutableLiveData<List<Place>> mPlaces;
    private PlaceRepository mRepo;
    private Place place;

    public void init(){
        if(mPlaces != null){
            return;
        }
        mRepo = PlaceRepository.getInstance();
        mPlaces = mRepo.getPlaceEmpty();
    }
    public LiveData<List<Place>> getPlaces(){
        return mPlaces;
    }
}
