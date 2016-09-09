package hu.schonherz.training.venue.vo;

import java.io.Serializable;
import java.text.DecimalFormat;

public class LatLngVo implements Serializable {
    private double lat;
    private double lng;

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

    public String toString() {
        return "Lat:" + this.lat + ", Lng:" + this.lng;
    }

    public int hashCode() {
        boolean prime = true;
        byte result = 1;
        long temp = Double.doubleToLongBits(this.lat);
        int result1 = 31 * result + (int) (temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.lng);
        result1 = 31 * result1 + (int) (temp ^ temp >>> 32);
        return result1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            LatLngVo other = (LatLngVo) obj;
            return Double.doubleToLongBits(this.lat) != Double.doubleToLongBits(other.lat) ? false : Double.doubleToLongBits(this.lng) == Double.doubleToLongBits(other.lng);
        }
    }
}
