package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.view.MBVenue;
import hu.schonherz.training.venue.service.VenueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "reviewBean")
@RequestScoped
public class MBReview {

    @ManagedProperty(value = "#{venueBean}")
    private MBVenue venue;

    @EJB
    VenueService venueService;

    private boolean profileBlocked = false;
    private boolean isAdmin = false;

    private static Logger LOG = LoggerFactory.getLogger(MBReview.class);


    public void blockProfile() {

        LOG.info("Profile is blocked");
        venue.getVenue().setEnabled(false);
        venueService.saveVenue(venue.getVenue());
    }

    public boolean isProfileBlocked() {
        return profileBlocked;
    }

    public void setProfileBlocked(boolean profileBlocked) {
        this.profileBlocked = profileBlocked;
    }

    public VenueService getVenueService() {
        return venueService;
    }

    public void setVenueService(VenueService venueService) {
        this.venueService = venueService;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public MBVenue getVenue() {
        return venue;
    }

    public void setVenue(MBVenue venue) {
        this.venue = venue;
    }
}

