package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.view.MBVenue;

import hu.schonherz.training.venue.service.VenueService;

import org.primefaces.event.FlowEvent;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "createVenueBean")
@RequestScoped
public class MBCreateVenue {
    @ManagedProperty(value = "#{venueBean}")
    private MBVenue venue;

    @EJB
    VenueService venueService;

    public String doCreate() {
        //venueService.createVenue(venue.getVenue());
        //VenueVo possibleVenue = venueService.getVenueByName(venue.getVenue().getName());
        if (false) {
            return "profile";
        } else {

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", venue.getVenue().getName() + " already exists.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
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
}