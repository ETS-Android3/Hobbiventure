package com.example.bottomnavigation.ui.search;

import androidx.lifecycle.MutableLiveData;


import com.example.bottomnavigation.R;

import java.util.ArrayList;
import java.util.List;

public class PlaceRepository {
    private static PlaceRepository instance;
    private ArrayList<Place> dataSet = new ArrayList<>();

    public static PlaceRepository getInstance() {
        if (instance == null) {
            instance = new PlaceRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Place>> getUdendoersSport() {
        setUdendoersSport();
        MutableLiveData<List<Place>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    public MutableLiveData<List<Place>> getVildmark() {
        setVildmark();
        MutableLiveData<List<Place>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    public MutableLiveData<List<Place>> getIndendoersSport() {
        setIndendoersSport();
        MutableLiveData<List<Place>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    public MutableLiveData<List<Place>> getHjemkundsskab() {
        setHjemkundsskab();
        MutableLiveData<List<Place>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setUdendoersSport() {
        dataSet.add(new Place("Asa Fodboldklub - Fodbold", R.drawable.asa_fodbold));
        dataSet.add(new Place("Aarhus 1900 - Atletik", R.drawable.aarhus_1900));
        dataSet.add(new Place("True Skov - Løb", R.drawable.true_skov));
        dataSet.add(new Place("Marselisborgskovene - Cykel", R.drawable.marselisborgskovene));
        dataSet.add(new Place("Vestereng - Discgolf", R.drawable.vestereng_discgolf));
        dataSet.add(new Place("Aarhus Ø - Surf", R.drawable.aarhus___surf));
        dataSet.add(new Place("Aarhus Watersports Complex - Watersports", R.drawable.aarhus_watersports_complex));

    }

    private void setVildmark() {
        dataSet.add(new Place("247outdoor - Mountainbiking", R.drawable._47outdoor));
        dataSet.add(new Place("Mols Bjerge - Vandring", R.drawable.mols_bjerge));
        dataSet.add(new Place("12. Århus Gruppe - Spejder", R.drawable.aarhusgruppe));
        dataSet.add(new Place("Brabrand Rostadion - Ro & Kajak", R.drawable.brabrand_rostadion));
        dataSet.add(new Place("Aarhus Bugten - Lystfiskeri", R.drawable.aarhus_bugten));
    }

    private void setHjemkundsskab() {

        dataSet.add(new Place("Tøndering Strik - Strik", R.drawable.t_ndering_strik));
        dataSet.add(new Place("Timm Vladimirs Køkken Aarhus - Madlavning", R.drawable.timm_vladimirs_k_kken_aarhus));
        dataSet.add(new Place("Sydbyens Bryglaug - Ølbrygning", R.drawable.sydbyensbryglaug));
        dataSet.add(new Place("PS Art Gallery - Maling", R.drawable.ps_art_gallery));
        dataSet.add(new Place("Skaberlyst - Syning", R.drawable.skaberlyst));
    }

    private void setIndendoersSport() {
        dataSet.add(new Place("Rush Trampolin Park - Trampolin", R.drawable.rush_aarhus));
        dataSet.add(new Place("DGI-huset Aarhus - Badminton", R.drawable.dgi_huset_aarhus));
        dataSet.add(new Place("Racehall - Gokart", R.drawable.racehall));
        dataSet.add(new Place("Gellerupbadet - Svømning", R.drawable.gellerupbadet));
        dataSet.add(new Place("Hasle Tennisklub - Tennis", R.drawable.hasle_tennisklub));
        dataSet.add(new Place("Aarhus Klatreklub - Klatring", R.drawable.aarhus_klatreklub));
    }
}

