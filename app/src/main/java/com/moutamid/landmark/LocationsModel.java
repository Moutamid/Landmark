package com.moutamid.landmark;

public class LocationsModel {
    String name, address;
    double lat, log;

    public LocationsModel(String name, String address, double lat, double log) {
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.log = log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLog() {
        return log;
    }

    public void setLog(double log) {
        this.log = log;
    }
}
