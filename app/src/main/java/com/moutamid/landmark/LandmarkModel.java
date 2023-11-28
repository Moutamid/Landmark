package com.moutamid.landmark;

import java.util.ArrayList;

public class LandmarkModel {
    int icon;
    String type;
    ArrayList<LocationsModel> locations;

    public LandmarkModel(int icon, String type, ArrayList<LocationsModel> locations) {
        this.icon = icon;
        this.type = type;
        this.locations = locations;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<LocationsModel> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<LocationsModel> locations) {
        this.locations = locations;
    }
}
