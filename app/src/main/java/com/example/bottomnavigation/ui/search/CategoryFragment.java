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



        ArrayList<Place> udendoersSportList= new ArrayList<>();
        udendoersSportList.add(new Place("Asa Fodboldklub - Fodbold", R.drawable.asa_fodbold));
        udendoersSportList.add(new Place("Aarhus 1900 - Atletik", R.drawable.aarhus_1900));
        udendoersSportList.add(new Place("True Skov - Løb", R.drawable.true_skov));
        udendoersSportList.add(new Place("Marselisborgskovene - Cykel", R.drawable.marselisborgskovene));
        udendoersSportList.add(new Place("Vestereng - Discgolf", R.drawable.vestereng_discgolf));
        udendoersSportList.add(new Place("Aarhus Ø - Surf", R.drawable.aarhus___surf));
        udendoersSportList.add(new Place("Aarhus Watersports Complex - Watersports", R.drawable.aarhus_watersports_complex));

    /*    ArrayList<Place> vildmarkList= new ArrayList<>();
        vildmarkList.add(new Place("247outdoor - Mountainbiking", R.drawable._47outdoor));
        vildmarkList.add(new Place("Mols Bjerge - Vandring", R.drawable.mols_bjerge));
        vildmarkList.add(new Place("12. Århus Gruppe - Spejder", R.drawable.aarhusgruppe));
        vildmarkList.add(new Place("Brabrand Rostadion - Ro & Kajak", R.drawable.brabrand_rostadion));
        vildmarkList.add(new Place("Aarhus Bugten - Lystfiskeri", R.drawable.aarhus_bugten));

        ArrayList<Place> hjemkundskabList= new ArrayList<>();
        hjemkundskabList.add(new Place("Tøndering Strik - Strik", R.drawable.t_ndering_strik));
        hjemkundskabList.add(new Place("Timm Vladimirs Køkken Aarhus - Madlavning", R.drawable.timm_vladimirs_k_kken_aarhus));
        hjemkundskabList.add(new Place("Sydbyens Bryglaug - Ølbrygning", R.drawable.sydbyensbryglaug));
        hjemkundskabList.add(new Place("PS Art Gallery - Maling", R.drawable.ps_art_gallery));
        hjemkundskabList.add(new Place("Skaberlyst - Syning", R.drawable.skaberlyst));

        ArrayList<Place> indendoersSportList= new ArrayList<>();
        indendoersSportList.add(new Place("Rush Trampolin Park - Trampolin", R.drawable.rush_aarhus));
        indendoersSportList.add(new Place("DGI-huset Aarhus - Badminton", R.drawable.dgi_huset_aarhus));
        indendoersSportList.add(new Place("Racehall - Gokart", R.drawable.racehall));
        indendoersSportList.add(new Place("Gellerupbadet - Svømning", R.drawable.gellerupbadet));
        indendoersSportList.add(new Place("Hasle Tennisklub - Tennis", R.drawable.hasle_tennisklub));
        indendoersSportList.add(new Place("Aarhus Klatreklub - Klatring", R.drawable.aarhus_klatreklub));
*/
        placeAdaptor = new PlaceAdaptor(udendoersSportList);
       // placeAdaptor = new PlaceAdaptor(vildmarkList);
       // placeAdaptor = new PlaceAdaptor(hjemkundskabList);
       // placeAdaptor = new PlaceAdaptor(indendoersSportList);


        placeList.setAdapter(placeAdaptor);
        placeList.hasFixedSize();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        final FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        fr.detach(CategoryFragment.this);
        fr.commit();
        binding = null;
    }
}