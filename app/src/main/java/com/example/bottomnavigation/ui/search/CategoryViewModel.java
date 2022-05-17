package com.example.bottomnavigation.ui.search;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewModel extends ViewModel {
    private MutableLiveData<List<Place>> mPlaces;
    private PlaceRepository mRepo;
    private Place place;

    public void initUS() {
        if (mPlaces != null) {
            return;
        }
        mRepo = PlaceRepository.getInstance();
        mPlaces = mRepo.getUdendoersSport();
    }

    public void initVM() {
        if (mPlaces != null) {
            return;
        }
        mRepo = PlaceRepository.getInstance();
        mPlaces = mRepo.getVildmark();
    }

    public void initIS() {
        if (mPlaces != null) {
            return;
        }
        mRepo = PlaceRepository.getInstance();
        mPlaces = mRepo.getIndendoersSport();
    }

    public void initHK() {
        if (mPlaces != null) {
            return;
        }
        mRepo = PlaceRepository.getInstance();
        mPlaces = mRepo.getHjemkundsskab();
    }

    public LiveData<List<Place>> getPlaces() {
        return mPlaces;
    }
}
