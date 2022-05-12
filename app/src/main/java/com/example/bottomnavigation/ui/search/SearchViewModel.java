package com.example.bottomnavigation.ui.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchViewModel extends ViewModel {

    private final MutableLiveData<String> outdoor;
    private final MutableLiveData<String> indoor;

    public SearchViewModel() {
        outdoor = new MutableLiveData<>();
        outdoor.setValue("Outdoor categories");
        indoor = new MutableLiveData<>();
        indoor.setValue("Indoor categories");
    }

    public LiveData<String> getTextOutdoor() {
        return outdoor;
    }
    public LiveData<String> getTextIndoor() {
        return indoor;
    }
}