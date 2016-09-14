package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.session.MBUser;
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

    @ManagedProperty(value = "#{userBean}")
    private MBUser user;

    @EJB
    VenueService venueService;

    private boolean profileBlocked;
    private boolean isAdmin = false;
    private boolean isOwner;

    private static final Logger LOG = LoggerFactory.getLogger(MBReview.class);

    public void blockProfile() {
        LOG.info("Profile enabled:" + profileBlocked);
        venue.getVenue().setEnabled(!profileBlocked);
        venueService.saveVenue(venue.getVenue());
    }

    public boolean isProfileBlocked() {
        return !venue.getVenue().getEnabled().booleanValue();
    }

    public VenueService getVenueService() {
        return venueService;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public MBVenue getVenue() {
        return venue;
    }

    public void setVenue(MBVenue venue) {
        this.venue = venue;
    }

    public boolean isOwner() {
        return venue.getVenue().getOwnerId().equals(user.getId());
    }

    public MBUser getUser() {
        return user;
    }

    public void setUser(MBUser user) {
        this.user = user;
    }
}

