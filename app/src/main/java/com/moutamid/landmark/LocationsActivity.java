package com.moutamid.landmark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.fxn.stash.Stash;
import com.moutamid.landmark.databinding.ActivityLocationsBinding;

public class LocationsActivity extends AppCompatActivity {
    ActivityLocationsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LandmarkModel model = (LandmarkModel) Stash.getObject(Constants.Pass, LandmarkModel.class);
        binding.name.setText(model.getType());

        binding.back.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.locationRC.setLayoutManager(new LinearLayoutManager(this));
        binding.locationRC.setHasFixedSize(false);
        LocationAdapter adapter = new LocationAdapter(this, model.getLocations());
        binding.locationRC.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Stash.clear(Constants.Pass);
    }
}