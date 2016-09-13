package hu.schonherz.training.venue.vo;

import java.io.Serializable;

public class LatLngVo implements Serializable {
    private double lat;
    private double lng;

    public LatLngVo() {
    }

    public LatLngVo(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String toString() {
        return "Lat:" + this.lat + ", Lng:" + this.lng;
    }

}
