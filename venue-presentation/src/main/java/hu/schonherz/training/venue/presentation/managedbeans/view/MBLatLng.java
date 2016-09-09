package hu.schonherz.training.venue.presentation.managedbeans.view;

import hu.schonherz.training.venue.vo.LatLngVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;


@ManagedBean(name = "latLngBean")
@ViewScoped
public class MBLatLng implements Serializable {
    private static final long serialVersionUID = 1942284715659078182L;

    private LatLngVo latLng;

    public LatLngVo getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLngVo latLng) {
        this.latLng = latLng;
    }
}
