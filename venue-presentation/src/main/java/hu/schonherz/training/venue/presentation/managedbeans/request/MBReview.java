package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.landing.vo.remote.RemoteUserVo;
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

    @ManagedProperty(value = "#{USER}")
    private RemoteUserVo user;

    @EJB
    VenueService venueService;

    private boolean profileBlocked;
    private boolean isAdmin = true;
    private boolean isOwner;

    private static final Logger LOG = LoggerFactory.getLogger(MBReview.class);

    public void blockProfile() {
        LOG.info("Profile enabled:" + profileBlocked);
        venue.getVenue().setEnabled(!profileBlocked);
        venueService.saveVenue(venue.getVenue());
    }

    public boolean isProfileBlocked() {
        if (venue.getVenue() != null)
            return !venue.getVenue().getEnabled().booleanValue();
        return true;
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
        if (venue.getVenue() != null)
            return venue.getVenue().getOwnerId().equals(user.getId());
        return false;
    }

    public RemoteUserVo getUser() {
        return user;
    }

    public void setUser(RemoteUserVo user) {
        this.user = user;
    }

    public void setProfileBlocked(boolean profileBlocked) {
        this.profileBlocked = profileBlocked;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }
}

