package com.moutamid.landmark;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.fxn.stash.Stash;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.moutamid.landmark.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    LocationsModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = (LocationsModel) Stash.getObject(Constants.Location, LocationsModel.class);

        binding.name.setText(model.getName());

        binding.back.setOnClickListener(v -> {
            onBackPressed();
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        binding.satelliteView.setOnClickListener(v -> {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            binding.satelliteView.setStrokeWidth(2);
            binding.defaultView.setStrokeWidth(0);
        });

        binding.defaultView.setOnClickListener(v -> {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            binding.satelliteView.setStrokeWidth(0);
            binding.defaultView.setStrokeWidth(2);
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Stash.clear(Constants.Location);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(model.getLat(), model.getLog());
        mMap.addMarker(new MarkerOptions().position(sydney).title(model.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
}