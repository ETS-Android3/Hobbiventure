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
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsFragment extends Fragment {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HistoryViewModel historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        View view = inflater.inflate(R.layout.activity_maps, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady( GoogleMap googleMap) {
                LatLng BouldersAarhus = new LatLng(56.20504565808364, 10.18151342350171);
                googleMap.addMarker(new MarkerOptions().position(BouldersAarhus).title("Aarhus Boulders"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(BouldersAarhus));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(BouldersAarhus, 15));

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

/**
 * Manipulates the map once available.
 * This callback is triggered when the map is ready to be used.
 * This is where we can add markers or lines, add listeners or move the camera. In this case,
 * we just add a marker near Sydney, Australia.
 * If Google Play services is not installed on the device, the user will be prompted to install
 * it inside the SupportMapFragment. This method will only be triggered once the user has
 * installed Google Play services and returned to the app.
 *
 * @Override public void onMapReady(GoogleMap googleMap) {
 * mMap = googleMap;
 * <p>
 * // Add a marker in Sydney and move the camera
 * LatLng BouldersAarhus = new LatLng(56.20504565808364, 10.18151342350171);
 * mMap.addMarker(new MarkerOptions().position(BouldersAarhus).title("Marker on Aarhus Boulders"));
 * mMap.moveCamera(CameraUpdateFactory.newLatLng(BouldersAarhus));
 * }
 */
