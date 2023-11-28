package com.moutamid.landmark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.moutamid.landmark.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<LandmarkModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Constants.checkApp(this);

        list = getList();

        binding.landRC.setLayoutManager(new LinearLayoutManager(this));
        binding.landRC.setHasFixedSize(false);

        LandmarkAdapter adapter = new LandmarkAdapter(this, list);
        binding.landRC.setAdapter(adapter);

    }

    private ArrayList<LandmarkModel> getList() {
        ArrayList<LandmarkModel> list = new ArrayList<>();

        ArrayList<LocationsModel> Old_Buildings = new ArrayList<>();
        Old_Buildings.add(new LocationsModel("Casa Loma", "1 Austin Terrace, Toronto, Ontario", 43.6780, -79.4095));
        list.add(new LandmarkModel(R.drawable.building_solid,"Old Buildings", Old_Buildings));

        ArrayList<LocationsModel> Museums = new ArrayList<>();
        Museums.add(new LocationsModel("Royal Ontario Museum (ROM)", "100 Queen's Park, Toronto, Ontario", 43.6684, -79.3948));
        Museums.add(new LocationsModel("Art Gallery of Ontario (AGO)", "317 Dundas Street West, Toronto, Ontario", 43.6546, -79.3923));
        list.add(new LandmarkModel(R.drawable.building_columns_solid, "Museums", Museums));

        ArrayList<LocationsModel> Attractions = new ArrayList<>();
        Attractions.add(new LocationsModel("The CN Tower", "301 Front Street West, Toronto, Ontario", 43.6426, -79.3871));
        Attractions.add(new LocationsModel("Ripley's Aquarium of Canada", "288 Bremner Boulevard, Toronto, Ontario", 43.6424, -79.3860));
        list.add(new LandmarkModel(R.drawable.magnet_solid, "Attractions", Attractions));

        ArrayList<LocationsModel> Markets = new ArrayList<>();
        Markets.add(new LocationsModel("St. Lawrence Market", "92 Front Street East, Toronto, Ontario", 43.6486, -79.3717));
        list.add(new LandmarkModel(R.drawable.store_solid, "Markets", Markets));

        ArrayList<LocationsModel> squareCenter = new ArrayList<>();
        squareCenter.add(new LocationsModel("City Hall & Nathan Philips Square", "100 Queen Street West, Toronto, Ontario", 43.6511, -79.3832));
        squareCenter.add(new LocationsModel("Yonge Dundas Square", "1 Dundas Street E, Toronto, Ontario", 43.6561, -79.3802));
        list.add(new LandmarkModel(R.drawable.mountain_city_solid, "Public Squares and Centers", squareCenter));

        ArrayList<LocationsModel> shopping = new ArrayList<>();
        shopping.add(new LocationsModel("CF Toronto Eaton Center", "220 Yonge Street, Toronto, Ontario", 43.6544, -79.3807));
        list.add(new LandmarkModel(R.drawable.shop_solid, "Shopping Centers", shopping));

        return list;
    }

}