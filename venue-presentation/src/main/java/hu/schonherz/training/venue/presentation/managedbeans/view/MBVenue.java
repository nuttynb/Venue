package hu.schonherz.training.venue.presentation.managedbeans.view;

import hu.schonherz.training.venue.vo.VenueVo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "venueBean")
@ViewScoped
public class MBVenue {
    private VenueVo venue = new VenueVo();

    public VenueVo getVenue() {
        return venue;
    }

    public void setVenue(VenueVo venue) {
        this.venue = venue;
    }
}
