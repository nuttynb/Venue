package hu.schonherz.training.venue.presentation.managedbeans.view;

import hu.schonherz.training.venue.vo.VenueVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name = "venueBean")
@ViewScoped
public class MBVenue implements Serializable {
    private static final long serialVersionUID = 2555967875000668429L;
    private VenueVo venue = new VenueVo();

    List<VenueVo> venues = new ArrayList<>();

    public VenueVo getVenue() {
        return venue;
    }

    public void setVenue(VenueVo venue) {
        this.venue = venue;
    }

    public List<VenueVo> getVenues() {
        return venues;
    }

    public void setVenues(List<VenueVo> venues) {
        this.venues = venues;
    }
}
