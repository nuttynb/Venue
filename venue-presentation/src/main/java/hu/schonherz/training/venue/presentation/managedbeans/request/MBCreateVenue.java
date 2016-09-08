package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.session.MBUser;
import hu.schonherz.training.venue.presentation.managedbeans.view.MBVenue;

import hu.schonherz.training.venue.service.VenueService;

import org.primefaces.event.FlowEvent;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "createVenueBean")
@RequestScoped
public class MBCreateVenue {
    @ManagedProperty(value = "#{venueBean}")
    private MBVenue venue;
    @ManagedProperty(value = "#{userBean}")
    private MBUser user;
    @EJB
    VenueService venueService;

    public String doCreate() {
        venue.getVenue().setOwnerId(user.getId());
        venueService.saveVenue(venue.getVenue());
        return "profile";
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public MBVenue getVenue() {
        return venue;
    }

    public void setVenue(MBVenue venue) {
        this.venue = venue;
    }

    public VenueService getVenueService() {
        return venueService;
    }

    public void setVenueService(VenueService venueService) {
        this.venueService = venueService;
    }

    public MBUser getUser() {
        return user;
    }

    public void setUser(MBUser user) {
        this.user = user;
    }
}
