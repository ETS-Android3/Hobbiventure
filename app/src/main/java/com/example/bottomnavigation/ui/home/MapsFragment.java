package com.example.bottomnavigation.ui.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.databinding.ActivityMapsBinding;
import com.example.bottomnavigation.ui.history.HistoryViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class MapsFragment extends Fragment {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    LatLng Arca = new LatLng(56.17412924773975, 10.185340046325729);
    LatLng Boulders = new LatLng(56.20504565808364, 10.18151342350171);
    LatLng Godsbanen = new LatLng(56.15361873942693, 10.193762196514863);
    LatLng Aros = new LatLng(56.15400659203265, 10.199630598366113);
    LatLng TaekwondoChungMoo = new LatLng(56.15608810830972, 10.18099313090452);
    LatLng BadmintonDGI = new LatLng(56.14913702381054, 10.206323811702811);


    private Marker markerBoulders;
    private Marker markerArca;
    private Marker markerGodsbanen;
    private Marker markerAros;
    private Marker markerBadmintonDGI;
    private Marker markerTaekwondoChungMoo;


            /*ArrayList<LatLng> MapList = new ArrayList<>();
            MapList.add(Boulders);*/

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HistoryViewModel historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        View view = inflater.inflate(R.layout.activity_maps, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                markerBoulders = googleMap.addMarker(new MarkerOptions().position(Boulders).title("Boulders Aarhus"));
                markerBoulders.setTag(0);
                markerArca = googleMap.addMarker(new MarkerOptions().position(Arca).title("Arca Crossfit Snedkeriget"));
                markerArca.setTag(0);
                markerGodsbanen = googleMap.addMarker(new MarkerOptions().position(Godsbanen).title("Kulturforening Godsbanen"));
                markerGodsbanen.setTag(0);
                markerAros = googleMap.addMarker(new MarkerOptions().position(Aros).title("Aros Kunstmuseum"));
                markerAros.setTag(0);
                markerBadmintonDGI = googleMap.addMarker(new MarkerOptions().position(BadmintonDGI).title("DGI Badminton klub, Fitness & Sports Center"));
                markerBadmintonDGI.setTag(0);
                markerTaekwondoChungMoo = googleMap.addMarker(new MarkerOptions().position(TaekwondoChungMoo).title("Aarhus Taekwondo Club Chung Moo"));
                markerTaekwondoChungMoo.setTag(0);

                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Aros, 13));
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        final FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        fr.detach(MapsFragment.this);
        fr.commit();
        binding = null;
    }
}
 /*  @Override
            public void onMapReady( GoogleMap googleMap) {
                LatLng BouldersAarhus = new LatLng(56.20504565808364, 10.18151342350171);
                googleMap.addMarker(new MarkerOptions().position(BouldersAarhus).title("Aarhus Boulders"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(BouldersAarhus));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(BouldersAarhus, 5));
                LatLng Arca = new LatLng(56.17412924773975, 10.185340046325729);
                googleMap.addMarker(new MarkerOptions().position(Arca).title("Arca Crossfit"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(Arca));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Arca, 15));
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(latLng);
                        markerOptions.title(latLng.latitude + " " + latLng.longitude);
                        googleMap.clear();
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                        googleMap.addMarker(markerOptions);
                    }
                });
            }*/
