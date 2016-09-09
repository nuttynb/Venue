package hu.schonherz.training.venue.presentation.managedbeans.request;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import hu.schonherz.training.venue.presentation.managedbeans.view.MBLatLng;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean(name = "mapInfoBean")
@RequestScoped
public class MBMapInfo implements Serializable {

    @ManagedProperty(value = "#{latLngBean}")
    MBLatLng latLng;

    private MapModel advancedModel;

    private Marker marker;

    @PostConstruct
    public void init() {
        advancedModel = new DefaultMapModel();
        LatLng coord1 = new LatLng(latLng.getLatLng().getLat(), latLng.getLatLng().getLng());
        advancedModel.addOverlay(new Marker(coord1));
    }

    public MapModel getAdvancedModel() {
        return advancedModel;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }

    public Marker getMarker() {
        return marker;
    }

    public MBLatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(MBLatLng latLng) {
        this.latLng = latLng;
    }

    public void setAdvancedModel(MapModel advancedModel) {
        this.advancedModel = advancedModel;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }
}