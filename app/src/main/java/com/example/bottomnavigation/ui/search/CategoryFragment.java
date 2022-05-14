package com.example.bottomnavigation.ui.search;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bottomnavigation.R;
import com.example.bottomnavigation.databinding.FragmentCategoryBinding;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    private FragmentCategoryBinding binding;

    PlaceAdaptor placeAdaptor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CategoryViewModel categoryViewModel =
                new ViewModelProvider(this).get(CategoryViewModel.class);

        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RecyclerView placeList = binding.rv;

        ArrayList<Place> outdoorList= new ArrayList<>();
        outdoorList.add(new Place("stedet", R.drawable.outdoor_156x96px));
        outdoorList.add(new Place("stedet2", R.drawable.outdoor_156x96px));
        outdoorList.add(new Place("stedet3", R.drawable.outdoor_156x96px));
        outdoorList.add(new Place("stedet4", R.drawable.outdoor_156x96px));
        outdoorList.add(new Place("stedet5", R.drawable.outdoor_156x96px));
        outdoorList.add(new Place("stedet6", R.drawable.outdoor_156x96px));

        ArrayList<Place> indoorList= new ArrayList<>();
        indoorList.add(new Place("stedet", R.drawable.outdoor_156x96px));
        indoorList.add(new Place("stedet2", R.drawable.outdoor_156x96px));
        indoorList.add(new Place("stedet3", R.drawable.outdoor_156x96px));
        indoorList.add(new Place("stedet4", R.drawable.outdoor_156x96px));
        indoorList.add(new Place("stedet5", R.drawable.outdoor_156x96px));
        indoorList.add(new Place("stedet6", R.drawable.outdoor_156x96px));

        placeAdaptor = new PlaceAdaptor(outdoorList);
        placeAdaptor = new PlaceAdaptor(indoorList);


        placeList.setAdapter(placeAdaptor);
        placeList.hasFixedSize();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}